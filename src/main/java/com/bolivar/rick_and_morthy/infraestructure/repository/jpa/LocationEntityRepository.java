package com.bolivar.rick_and_morthy.infraestructure.repository.jpa;

import com.bolivar.rick_and_morthy.infraestructure.repository.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationEntityRepository extends JpaRepository<LocationEntity, Long> {
}
