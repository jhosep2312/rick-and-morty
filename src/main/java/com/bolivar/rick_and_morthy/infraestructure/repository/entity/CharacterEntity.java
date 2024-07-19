package com.bolivar.rick_and_morthy.infraestructure.repository.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "character_bolivar")
public class CharacterEntity extends BaseEntity{

    @Id
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;
    private String url;
    private String created;

    @ManyToMany
    @JoinTable(
            name = "character_location",
            joinColumns = @JoinColumn(name = "character_bolivar_id"),
            inverseJoinColumns = @JoinColumn(name = "location_bolivar_id"))
    private Set<LocationEntity> locations;

}
