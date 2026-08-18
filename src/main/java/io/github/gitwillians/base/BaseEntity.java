package io.github.gitwillians.base;

import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @UuidGenerator
    private String id;

    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}