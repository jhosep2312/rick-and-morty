package com.bolivar.rick_and_morthy.infraestructure.repository.mapper;

import com.bolivar.rick_and_morthy.domain.Character;
import com.bolivar.rick_and_morthy.domain.Location;
import com.bolivar.rick_and_morthy.domain.PageResponse;
import com.bolivar.rick_and_morthy.infraestructure.repository.entity.CharacterEntity;
import org.springframework.data.domain.Page;

import static com.bolivar.rick_and_morthy.infraestructure.utils.FunctionUtils.safeStream;

public class CharacterMapper {

    public static PageResponse<Character> toDomain(Page<CharacterEntity> entity) {
        return PageResponse.<Character>builder()
                .size(entity.getSize())
                .page(entity.getNumber())
                .totalElements(entity.getTotalElements())
                .totalPages(entity.getTotalPages())
                .elements(
                        safeStream(entity.getContent()).map(CharacterMapper::toDomain).toList())
                .build();
    }

    public static Character toDomain(CharacterEntity entity) {

        return Character.builder()
                .id(entity.getId())
                .name(entity.getName())
                .status(entity.getStatus())
                .species(entity.getSpecies())
                .type(entity.getType())
                .gender(entity.getGender())
                .image(entity.getImage())
                .url(entity.getUrl())
                .created(entity.getCreated())
                .locations(LocationMapper.toDomain(entity.getLocations()))
                .build();

    }

    public static CharacterEntity toEntity(Character domain) {

        return CharacterEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .status(domain.getStatus())
                .species(domain.getSpecies())
                .type(domain.getType())
                .gender(domain.getGender())
                .image(domain.getImage())
                .url(domain.getUrl())
                .created(domain.getCreated())
                //.locations(LocationMapper.toEntity(domain.getLocations()))
                .build();

    }

}
