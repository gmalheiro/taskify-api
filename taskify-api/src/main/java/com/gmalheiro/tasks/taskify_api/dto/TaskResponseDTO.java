package com.gmalheiro.tasks.taskify_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskResponseDTO {
    private long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean completed;
}
