package com.incidents.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncidentResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt;
}