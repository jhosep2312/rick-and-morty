package com.bolivar.rick_and_morthy.infraestructure.repository.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import static org.springframework.data.jpa.domain.AbstractAuditable_.LAST_MODIFIED_BY;


@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseEntity {

    private String lastModifiedBy;

    private LocalDateTime lastModifiedAt;

    private LocalDateTime createdAt;

    @PrePersist
    @PreUpdate
    public void prePersistUpdate() {
        setAudValues();
    }

    private void setAudValues() {
        if (lastModifiedBy == null) lastModifiedBy = LAST_MODIFIED_BY;
        if (createdAt == null) createdAt = LocalDateTime.now();
        lastModifiedAt = LocalDateTime.now();
    }
}
