package com.incidents.controller;

import com.incidents.dto.IncidentRequestDTO;
import com.incidents.dto.IncidentResponseDTO;

import com.incidents.service.IncidentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
@RequiredArgsConstructor
@Tag(
        name = "Incidents",
        description = "API de gerenciamento de incidentes"
)
public class IncidentController {

    private final IncidentService incidentService;

    // =========================
    // GET ALL
    // =========================

    @GetMapping
    @Operation(
            summary = "Listar todos os incidentes"
    )

    @Cacheable("incidents")
    public ResponseEntity<Page<IncidentResponseDTO>> findAll(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size,

            @RequestParam(required = false)
            String severity
    ) {

        return ResponseEntity.ok(

                incidentService.findAll(
                        page,
                        size,
                        severity
                )
        );
    }

    // =========================
    // GET BY ID
    // =========================

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar incidente por ID"
    )
    public ResponseEntity<IncidentResponseDTO> findById(

            @PathVariable Long id
    ) {

        return ResponseEntity.ok(

                incidentService.findById(id)
        );
    }

    // =========================
    // CREATE
    // =========================

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    @CacheEvict(
            value = "incidents",
            allEntries = true
    )

    @Operation(
            summary = "Criar novo incidente"
    )
    public ResponseEntity<IncidentResponseDTO> create(

            @Valid
            @RequestBody
            IncidentRequestDTO dto
    ) {

        return ResponseEntity.status(HttpStatus.CREATED)

                .body(

                        incidentService.create(dto)
                );
    }

    // =========================
    // UPDATE
    // =========================

    @PutMapping("/{id}")

    @CacheEvict(
            value = "incidents",
            allEntries = true
    )

    @Operation(
            summary = "Atualizar incidente"
    )
    public ResponseEntity<IncidentResponseDTO> update(

            @PathVariable Long id,

            @Valid
            @RequestBody
            IncidentRequestDTO dto
    ) {

        return ResponseEntity.ok(

                incidentService.update(
                        id,
                        dto
                )
        );
    }

    // =========================
    // DELETE
    // =========================

    @DeleteMapping("/{id}")

    @CacheEvict(
            value = "incidents",
            allEntries = true
    )

    @Operation(
            summary = "Excluir incidente"
    )
    public ResponseEntity<Void> delete(

            @PathVariable Long id
    ) {

        incidentService.delete(id);

        return ResponseEntity.noContent()
                .build();
    }

    // =========================
    // HEALTH CHECK
    // =========================

    @GetMapping("/health")
    public ResponseEntity<String> health() {

        return ResponseEntity.ok(
                "Incident API Running 🚀"
        );
    }
}