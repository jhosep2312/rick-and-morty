package com.bolivar.rick_and_morthy.infraestructure.rest.dto;

import com.bolivar.rick_and_morthy.infraestructure.rest.validations.OnCreate;
import com.bolivar.rick_and_morthy.infraestructure.rest.validations.OnUpdate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationRequestDto {

    @Null(groups = {OnUpdate.class})
    @NotNull(groups = {OnCreate.class})
    private Long id;

    @NotNull(groups = {OnUpdate.class})
    private String name;
    @NotNull(groups = {OnUpdate.class})
    private String type;
    @NotNull(groups = {OnUpdate.class})
    private String dimension;
    @NotNull(groups = {OnUpdate.class})
    private String url;
    @NotNull(groups = {OnUpdate.class})
    private String created;
}
