package com.incidents.repository;

import com.incidents.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    // =========================
    // FIND BY EMAIL
    // =========================

    Optional<User> findByEmail(
            String email
    );

    // =========================
    // EXISTS EMAIL
    // =========================

    boolean existsByEmail(
            String email
    );
}