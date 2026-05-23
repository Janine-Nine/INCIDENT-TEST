package com.incidents.repository;

import com.incidents.entity.RefreshToken;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository
        extends JpaRepository<RefreshToken, Long> {

    // =========================
    // FIND TOKEN
    // =========================

    Optional<RefreshToken> findByToken(
            String token
    );

    // =========================
    // DELETE TOKEN
    // =========================

    void deleteByToken(
            String token
    );
}