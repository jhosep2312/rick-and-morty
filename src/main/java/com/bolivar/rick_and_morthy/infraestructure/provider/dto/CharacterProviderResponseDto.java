package com.bolivar.rick_and_morthy.infraestructure.provider.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CharacterProviderResponseDto {

    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private NameUrl origin;
    private NameUrl location;
    private String image;
    private Set<String> episode;
    private String url;
    private String created;

    @Data
    @Builder
    public static class NameUrl {

        String name;
        String url;

    }

}
