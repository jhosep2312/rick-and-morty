package com.bolivar.rick_and_morthy.infraestructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "location_bolivar")
public class LocationEntity extends BaseEntity {

    @Id
    private Long id;
    private String name;
    private String type;
    private String dimension;
    //List<String> residents;
    private String url;
    private String created;

}
