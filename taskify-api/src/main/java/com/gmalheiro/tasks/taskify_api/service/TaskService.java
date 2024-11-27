package com.gmalheiro.tasks.taskify_api.service;

import com.gmalheiro.tasks.taskify_api.dto.TaskRequestDTO;
import com.gmalheiro.tasks.taskify_api.dto.TaskResponseDTO;
import com.gmalheiro.tasks.taskify_api.model.Task;
import com.gmalheiro.tasks.taskify_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }


    public List<TaskResponseDTO> findAllTasks () {
        return repository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public TaskResponseDTO createTask (TaskRequestDTO taskRequestDTO) {
        Task task = new Task();
        task.setTitle(taskRequestDTO.getTitle());
        task.setDescription(taskRequestDTO.getDescription());
        task.setCompleted(taskRequestDTO.getCompleted());
        task.setCreatedAt(LocalDateTime.now());
        repository.save(task);
        return  convertToResponseDTO(task);
    }

    public TaskResponseDTO findTaskById (long id) {
        return convertToResponseDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task was not found")));
    }

    public TaskResponseDTO updateTask (long id, TaskRequestDTO updatedTask) {
        return repository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.getCompleted());
            task.setCreatedAt(LocalDateTime.now());
            return  convertToResponseDTO(repository.save(task));
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask (long id) {
        repository.deleteById(id);
    }


    private TaskResponseDTO convertToResponseDTO(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCreatedAt(task.getCreatedAt());
        dto.setCompleted(task.getCompleted());
        return dto;
    }


}
