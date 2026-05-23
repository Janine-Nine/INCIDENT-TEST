package com.incidents.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    // =========================
    // EMAIL
    // =========================

    @Column(
            nullable = false,
            unique = true
    )
    private String email;

    // =========================
    // PASSWORD
    // =========================

    @Column(
            nullable = false
    )
    private String password;

    // =========================
    // ROLE
    // =========================

    @Column(
            nullable = false
    )
    private String role;

    // =========================
    // CREATED AT
    // =========================

    private LocalDateTime createdAt;

    // =========================
    // UPDATED AT
    // =========================

    private LocalDateTime updatedAt;

    // =========================
    // AUTO TIMESTAMP
    // =========================

    @PrePersist
    public void prePersist() {

        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {

        updatedAt = LocalDateTime.now();
    }
}