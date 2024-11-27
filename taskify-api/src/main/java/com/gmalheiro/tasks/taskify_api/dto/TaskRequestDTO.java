package com.gmalheiro.tasks.taskify_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequestDTO {
    @NotNull(message = "Title is required")
    private String title;
    private String description;
    private Boolean completed;
}
