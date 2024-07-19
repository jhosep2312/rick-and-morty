package com.bolivar.rick_and_morthy.infraestructure.provider.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class LocationProviderResponseDto {

    private Long id;
    private String name;
    private String type;
    private String dimension;
    Set<String> residents;
    private String url;
    private String created;
}
