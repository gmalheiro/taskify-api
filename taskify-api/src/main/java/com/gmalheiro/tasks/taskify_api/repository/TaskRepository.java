package com.gmalheiro.tasks.taskify_api.repository;

import com.gmalheiro.tasks.taskify_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    Task findByTitleAndDescription(String title, String description);
}
