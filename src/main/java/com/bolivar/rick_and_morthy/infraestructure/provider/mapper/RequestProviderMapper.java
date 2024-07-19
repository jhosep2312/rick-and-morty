package com.bolivar.rick_and_morthy.infraestructure.provider.mapper;

import com.bolivar.rick_and_morthy.domain.Character;
import com.bolivar.rick_and_morthy.domain.Location;
import com.bolivar.rick_and_morthy.infraestructure.provider.dto.CharacterProviderResponseDto;
import com.bolivar.rick_and_morthy.infraestructure.provider.dto.LocationProviderResponseDto;

import java.util.Set;

public class RequestProviderMapper {

    public static Character toDomain(CharacterProviderResponseDto provider) {

        return Character.builder()
                .id(provider.getId())
                .name(provider.getName())
                .status(provider.getStatus())
                .species(provider.getSpecies())
                .type(provider.getType())
                .gender(provider.getGender())
                .image(provider.getImage())
                .url(provider.getUrl())
                .created(provider.getCreated())
                //.locations(Set.of(toDomain(provider.getLocation())) )
                .build();
    }

    public static Location toDomain(LocationProviderResponseDto location){

        return Location.builder()
                .id(location.getId())
                .name(location.getName())
                .type(location.getType())
                .dimension(location.getDimension())
                .url(location.getUrl())
                .residents(location.getResidents())
                .created(location.getCreated())
                .build();

    }

}
