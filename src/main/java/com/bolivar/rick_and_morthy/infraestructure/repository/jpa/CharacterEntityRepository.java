package com.bolivar.rick_and_morthy.infraestructure.repository.jpa;

import com.bolivar.rick_and_morthy.infraestructure.repository.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterEntityRepository extends JpaRepository<CharacterEntity, Long> {
}
