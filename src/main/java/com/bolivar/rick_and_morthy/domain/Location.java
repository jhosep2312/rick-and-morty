package com.bolivar.rick_and_morthy.domain;


import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Location {

    private Long id;
    private String name;
    private String type;
    private String dimension;
    private String url;
    private Set<String> residents;
    private String created;
}
