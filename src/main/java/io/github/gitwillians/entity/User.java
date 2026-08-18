package io.github.gitwillians.entity;

import io.github.gitwillians.base.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {

    private String username;

    private String email;

    private String password;
}