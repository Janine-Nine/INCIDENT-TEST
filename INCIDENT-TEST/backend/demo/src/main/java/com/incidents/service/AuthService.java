package com.incidents.service;

import com.incidents.config.JwtService;

import com.incidents.dto.AuthResponseDTO;
import com.incidents.dto.LoginRequestDTO;

import com.incidents.entity.User;

import com.incidents.exception.UnauthorizedException;

import com.incidents.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final RefreshTokenService refreshTokenService;

    // =========================
    // LOGIN
    // =========================

    public AuthResponseDTO login(
            LoginRequestDTO dto
    ) {

        User user = repository.findByEmail(
                dto.getEmail()
        ).orElseThrow(() ->

                new UnauthorizedException(
                        "Invalid credentials"
                )
        );

        boolean matches = passwordEncoder.matches(

                dto.getPassword(),

                user.getPassword()
        );

        if (!matches) {

            throw new UnauthorizedException(
                    "Invalid credentials"
            );
        }

        String token = jwtService.generateToken(
                user.getEmail()
        );

        String refreshToken =
                refreshTokenService.createRefreshToken(
                        user
                );

        log.info(
                "User authenticated: {}",
                user.getEmail()
        );

        return AuthResponseDTO.builder()

                .token(token)

                .refreshToken(refreshToken)

                .type("Bearer")

                .email(user.getEmail())

                .build();
    }

    // =========================
    // REGISTER
    // =========================

    public AuthResponseDTO register(
            LoginRequestDTO dto
    ) {

        boolean exists = repository.findByEmail(
                dto.getEmail()
        ).isPresent();

        if (exists) {

            throw new RuntimeException(
                    "User already exists"
            );
        }

        User user = User.builder()

                .email(dto.getEmail())

                .password(

                        passwordEncoder.encode(
                                dto.getPassword()
                        )
                )

                .role("USER")

                .build();

        repository.save(user);

        String token = jwtService.generateToken(
                user.getEmail()
        );

        String refreshToken =
                refreshTokenService.createRefreshToken(
                        user
                );

        log.info(
                "User registered: {}",
                user.getEmail()
        );

        return AuthResponseDTO.builder()

                .token(token)

                .refreshToken(refreshToken)

                .type("Bearer")

                .email(user.getEmail())

                .build();
    }
}