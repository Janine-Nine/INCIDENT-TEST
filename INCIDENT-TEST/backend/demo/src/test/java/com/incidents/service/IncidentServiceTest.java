package com.incidents.service;

import com.incidents.dto.IncidentRequestDTO;
import com.incidents.entity.Incident;
import com.incidents.exception.ResourceNotFoundException;
import com.incidents.repository.IncidentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IncidentServiceTest {

    @Mock
    private IncidentRepository incidentRepository;

    @InjectMocks
    private IncidentService incidentService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve buscar incidente por ID")
    void shouldFindIncidentById() {

        Incident incident = Incident.builder()
                .id(1L)
                .title("Erro Login")
                .description("Falha autenticação")
                .status("ABERTO")
                .createdAt(LocalDateTime.now())
                .build();

        when(incidentRepository.findById(1L))
                .thenReturn(Optional.of(incident));

        Incident result = incidentService.findById(1L);

        assertNotNull(result);
        assertEquals("Erro Login", result.getTitle());
    }

    @Test
    @DisplayName("Deve lançar exceção quando incidente não existir")
    void shouldThrowExceptionWhenIncidentNotFound() {

        when(incidentRepository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> incidentService.findById(99L)
        );
    }

    @Test
    @DisplayName("Deve criar incidente com sucesso")
    void shouldCreateIncidentSuccessfully() {

        IncidentRequestDTO dto = IncidentRequestDTO.builder()
                .title("Erro API")
                .description("Erro backend")
                .status("ABERTO")
                .build();

        Incident incident = Incident.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .createdAt(LocalDateTime.now())
                .build();

        when(incidentRepository.save(any(Incident.class)))
                .thenReturn(incident);

        Incident saved = incidentService.createIncident(dto);

        assertNotNull(saved);
        assertEquals("Erro API", saved.getTitle());
    }
}