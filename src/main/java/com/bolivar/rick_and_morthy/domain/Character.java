package com.bolivar.rick_and_morthy.domain;

import com.bolivar.rick_and_morthy.infraestructure.repository.entity.LocationEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Character {

    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;
    private String url;
    private String created;

    Set<Location> locations;
}
