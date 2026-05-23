package com.incidents.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.incidents.dto.IncidentRequestDTO;
import com.incidents.service.IncidentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class IncidentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IncidentService incidentService;

    @Test
    @DisplayName("Deve criar um incidente com sucesso")
    void shouldCreateIncidentSuccessfully() throws Exception {

        IncidentRequestDTO request = IncidentRequestDTO.builder()
                .title("Erro API")
                .description("Erro ao salvar")
                .status("ABERTO")
                .build();

        Mockito.when(incidentService.createIncident(Mockito.any()))
                .thenReturn(null);

        mockMvc.perform(post("/incidents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Deve retornar erro ao enviar campos vazios")
    void shouldReturnBadRequestWhenFieldsAreEmpty() throws Exception {

        IncidentRequestDTO request = IncidentRequestDTO.builder()
                .title("")
                .description("")
                .status("")
                .build();

        mockMvc.perform(post("/incidents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}