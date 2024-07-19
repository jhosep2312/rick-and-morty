package com.bolivar.rick_and_morthy.infraestructure.repository.mapper;

import com.bolivar.rick_and_morthy.domain.Character;
import com.bolivar.rick_and_morthy.domain.Location;
import com.bolivar.rick_and_morthy.domain.PageResponse;
import com.bolivar.rick_and_morthy.infraestructure.repository.entity.LocationEntity;
import org.springframework.data.domain.Page;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bolivar.rick_and_morthy.infraestructure.utils.FunctionUtils.safeStream;

public class LocationMapper {


    public static Set<Location> toDomain(Set<LocationEntity> entity) {

        if (Objects.isNull(entity))
            return null;
        return entity.stream().map(LocationMapper::toDomain)
                .collect(Collectors.toSet());
    }

    public static Location toDomain(LocationEntity entity) {

        return Location.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .dimension(entity.getDimension())
                .url(entity.getUrl())
                .created(entity.getCreated())
                .build();

    }

    public static Set<LocationEntity> toEntity(Set<Location> domain) {

        if (Objects.isNull(domain))
            return null;
        return domain.stream().map(LocationMapper::toEntity)
                .collect(Collectors.toSet());
    }

    public static LocationEntity toEntity(Location domain) {

        return LocationEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .type(domain.getType())
                .dimension(domain.getDimension())
                .url(domain.getUrl())
                .created(domain.getCreated())
                .build();

    }

    public static PageResponse<Location> toDomain(Page<LocationEntity> entity) {

        return PageResponse.<Location>builder()
                .size(entity.getSize())
                .page(entity.getNumber())
                .totalElements(entity.getTotalElements())
                .totalPages(entity.getTotalPages())
                .elements(safeStream(entity.getContent()).map(LocationMapper::toDomain).toList())
                .build();
    }
}
