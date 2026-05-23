package com.incidents.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.incidents.dto.IncidentRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IncidentIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Fluxo completo de criação de incidente")
    void shouldCreateIncidentFlowSuccessfully() throws Exception {

        IncidentRequestDTO request = IncidentRequestDTO.builder()
                .title("Erro produção")
                .description("Sistema caiu")
                .status("ABERTO")
                .build();

        mockMvc.perform(post("/incidents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Deve listar incidentes")
    void shouldListIncidents() throws Exception {

        mockMvc.perform(get("/incidents"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deve retornar 404 para incidente inexistente")
    void shouldReturn404WhenIncidentNotFound() throws Exception {

        mockMvc.perform(get("/incidents/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Deve deletar incidente")
    void shouldDeleteIncident() throws Exception {

        mockMvc.perform(delete("/incidents/1"))
                .andExpect(status().isNoContent());
    }
}