package com.incidents.service;

import com.incidents.dto.IncidentRequestDTO;
import com.incidents.dto.IncidentResponseDTO;

import com.incidents.entity.Incident;

import com.incidents.exception.ResourceNotFoundException;

import com.incidents.repository.IncidentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.data.domain.*;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class IncidentService {

    private final IncidentRepository repository;

    // =========================
    // GET ALL
    // =========================

    @Cacheable("incidents")
    public Page<IncidentResponseDTO> findAll(

            int page,

            int size,

            String severity
    ) {

        Pageable pageable = PageRequest.of(

                page,

                size,

                Sort.by("createdAt")
                        .descending()
        );

        Page<Incident> incidents;

        if (

                severity != null &&

                !severity.isBlank()

        ) {

            incidents = repository.findBySeverity(
                    severity,
                    pageable
            );

        } else {

            incidents = repository.findAll(
                    pageable
            );
        }

        log.info(
                "Incidents loaded successfully"
        );

        return incidents.map(this::toResponseDTO);
    }

    // =========================
    // GET BY ID
    // =========================

    public IncidentResponseDTO findById(
            Long id
    ) {

        Incident incident = repository.findById(id)

                .orElseThrow(() ->

                        new ResourceNotFoundException(
                                "Incident not found: " + id
                        )
                );

        log.info(
                "Incident loaded: {}",
                incident.getTitle()
        );

        return toResponseDTO(incident);
    }

    // =========================
    // CREATE
    // =========================

    @CacheEvict(
            value = "incidents",
            allEntries = true
    )
    public IncidentResponseDTO create(
            IncidentRequestDTO dto
    ) {

        Incident incident = Incident.builder()

                .title(dto.getTitle())

                .description(dto.getDescription())

                .severity(dto.getSeverity())

                .status(dto.getStatus())

                .createdAt(LocalDateTime.now())

                .build();

        repository.save(incident);

        log.info(
                "Incident created: {}",
                incident.getTitle()
        );

        return toResponseDTO(incident);
    }

    // =========================
    // UPDATE
    // =========================

    @CacheEvict(
            value = "incidents",
            allEntries = true
    )
    public IncidentResponseDTO update(

            Long id,

            IncidentRequestDTO dto
    ) {

        Incident incident = repository.findById(id)

                .orElseThrow(() ->

                        new ResourceNotFoundException(
                                "Incident not found: " + id
                        )
                );

        incident.setTitle(dto.getTitle());

        incident.setDescription(dto.getDescription());

        incident.setSeverity(dto.getSeverity());

        incident.setStatus(dto.getStatus());

        repository.save(incident);

        log.info(
                "Incident updated: {}",
                incident.getId()
        );

        return toResponseDTO(incident);
    }

    // =========================
    // DELETE
    // =========================

    @CacheEvict(
            value = "incidents",
            allEntries = true
    )
    public void delete(Long id) {

        Incident incident = repository.findById(id)

                .orElseThrow(() ->

                        new ResourceNotFoundException(
                                "Incident not found: " + id
                        )
                );

        repository.delete(incident);

        log.warn(
                "Incident deleted: {}",
                incident.getId()
        );
    }

    // =========================
    // DTO MAPPER
    // =========================

    private IncidentResponseDTO toResponseDTO(
            Incident incident
    ) {

        return IncidentResponseDTO.builder()

                .id(incident.getId())

                .title(incident.getTitle())

                .description(incident.getDescription())

                .severity(incident.getSeverity())

                .status(incident.getStatus())

                .createdAt(incident.getCreatedAt())

                .build();
    }
}