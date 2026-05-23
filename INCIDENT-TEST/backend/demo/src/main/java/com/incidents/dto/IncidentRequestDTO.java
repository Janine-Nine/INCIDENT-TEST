package com.incidents.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IncidentRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 10)
    private String description;

    @NotBlank(message = "Severity is required")
    private String severity;

    @NotBlank(message = "Status is required")
    private String status;
}