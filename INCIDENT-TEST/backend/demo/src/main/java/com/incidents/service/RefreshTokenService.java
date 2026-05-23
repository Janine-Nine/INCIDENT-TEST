package com.incidents.service;

import com.incidents.config.JwtService;

import com.incidents.dto.AuthResponseDTO;
import com.incidents.dto.RefreshTokenRequestDTO;

import com.incidents.entity.RefreshToken;
import com.incidents.entity.User;

import com.incidents.exception.UnauthorizedException;

import com.incidents.repository.RefreshTokenRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class RefreshTokenService {

    private final RefreshTokenRepository repository;

    private final JwtService jwtService;

    // =========================
    // CREATE REFRESH TOKEN
    // =========================

    public String createRefreshToken(
            User user
    ) {

        RefreshToken refreshToken =
                RefreshToken.builder()

                        .token(
                                UUID.randomUUID().toString()
                        )

                        .expiryDate(
                                Instant.now()
                                        .plusSeconds(
                                                604800
                                        )
                        )

                        .user(user)

                        .build();

        repository.save(refreshToken);

        log.info(
                "Refresh token generated for {}",
                user.getEmail()
        );

        return refreshToken.getToken();
    }

    // =========================
    // REFRESH JWT
    // =========================

    public AuthResponseDTO refreshToken(
            RefreshTokenRequestDTO request
    ) {

        RefreshToken refreshToken = repository

                .findByToken(
                        request.getRefreshToken()
                )

                .orElseThrow(() ->

                        new UnauthorizedException(
                                "Invalid refresh token"
                        )
                );

        if (

                refreshToken.getExpiryDate()

                        .isBefore(Instant.now())

        ) {

            repository.delete(refreshToken);

            throw new UnauthorizedException(
                    "Refresh token expired"
            );
        }

        String jwt = jwtService.generateToken(

                refreshToken.getUser()
                        .getEmail()
        );

        log.info(
                "JWT refreshed for {}",
                refreshToken
                        .getUser()
                        .getEmail()
        );

        return AuthResponseDTO.builder()

                .token(jwt)

                .refreshToken(
                        refreshToken.getToken()
                )

                .type("Bearer")

                .email(
                        refreshToken
                                .getUser()
                                .getEmail()
                )

                .build();
    }
}