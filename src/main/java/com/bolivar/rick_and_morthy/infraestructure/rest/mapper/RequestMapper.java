package com.bolivar.rick_and_morthy.infraestructure.rest.mapper;

import com.bolivar.rick_and_morthy.domain.Character;
import com.bolivar.rick_and_morthy.domain.Location;
import com.bolivar.rick_and_morthy.infraestructure.rest.dto.CharacterRequestDto;
import com.bolivar.rick_and_morthy.infraestructure.rest.dto.LocationRequestDto;

public class RequestMapper {

    public static Character toDomain(CharacterRequestDto requestDto) {

        return Character.builder()
                .id(requestDto.getId())
                .status(requestDto.getStatus())
                .species(requestDto.getSpecies())
                .type(requestDto.getType())
                .gender(requestDto.getGender())
                .image(requestDto.getImage())
                .url(requestDto.getUrl())
                .created(requestDto.getCreated())
                .build();

    }

    public static Location toDomain(LocationRequestDto requestDto) {

        return Location.builder()
                .id(requestDto.getId())
                .name(requestDto.getName())
                .type(requestDto.getType())
                .dimension(requestDto.getDimension())
                .url(requestDto.getUrl())
                .created(requestDto.getCreated())
                .build();

    }
}