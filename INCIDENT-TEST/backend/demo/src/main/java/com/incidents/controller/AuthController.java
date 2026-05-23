package com.incidents.controller;

import com.incidents.dto.AuthResponseDTO;
import com.incidents.dto.LoginRequestDTO;
import com.incidents.dto.RefreshTokenRequestDTO;

import com.incidents.service.AuthService;
import com.incidents.service.RefreshTokenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(
        name = "Authentication",
        description = "API de autenticação JWT"
)
public class AuthController {

    private final AuthService authService;

    private final RefreshTokenService refreshTokenService;

    // =========================
    // LOGIN
    // =========================

    @PostMapping("/login")

    @Operation(
            summary = "Autenticar usuário"
    )

    public ResponseEntity<AuthResponseDTO> login(

            @Valid
            @RequestBody
            LoginRequestDTO dto
    ) {

        return ResponseEntity.ok(

                authService.login(dto)
        );
    }

    // =========================
    // REFRESH TOKEN
    // =========================

    @PostMapping("/refresh")

    @Operation(
            summary = "Gerar novo token JWT"
    )

    public ResponseEntity<AuthResponseDTO> refreshToken(

            @RequestBody
            RefreshTokenRequestDTO request
    ) {

        return ResponseEntity.ok(

                refreshTokenService.refreshToken(
                        request
                )
        );
    }

    // =========================
    // REGISTER
    // =========================

    @PostMapping("/register")

    @ResponseStatus(HttpStatus.CREATED)

    @Operation(
            summary = "Registrar novo usuário"
    )

    public ResponseEntity<AuthResponseDTO> register(

            @Valid
            @RequestBody
            LoginRequestDTO dto
    ) {

        return ResponseEntity.status(HttpStatus.CREATED)

                .body(

                        authService.register(dto)
                );
    }

    // =========================
    // VALIDATE TOKEN
    // =========================

    @GetMapping("/validate")

    @Operation(
            summary = "Validar JWT"
    )

    public ResponseEntity<String> validate() {

        return ResponseEntity.ok(
                "JWT válido ✅"
        );
    }

    // =========================
    // LOGOUT
    // =========================

    @PostMapping("/logout")

    @Operation(
            summary = "Logout do usuário"
    )

    public ResponseEntity<String> logout() {

        return ResponseEntity.ok(
                "Logout realizado com sucesso"
        );
    }
}