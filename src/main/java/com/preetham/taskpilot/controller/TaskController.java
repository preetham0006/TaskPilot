package com.preetham.taskpilot.controller;

import com.preetham.taskpilot.entity.Task;
import com.preetham.taskpilot.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import com.preetham.taskpilot.dto.TaskRequestDTO;
import com.preetham.taskpilot.dto.TaskResponseDTO;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET /tasks
    @GetMapping("/tasks")
    public List<TaskResponseDTO> getAllTasks() {
    return taskService.getAllTasks();
    }

    // GET /tasks/{id}
    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Integer id) {

    TaskResponseDTO task = taskService.getTaskById(id);

    if (task == null) {
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(task);
}
@PostMapping("/tasks")
public TaskResponseDTO createTask(@Valid @RequestBody TaskRequestDTO requestDTO) {
    return taskService.createTask(requestDTO);
}
@PutMapping("/tasks/{id}")
public ResponseEntity<TaskResponseDTO> updateTask(
        @PathVariable Integer id,
        @Valid @RequestBody TaskRequestDTO requestDTO) {

    TaskResponseDTO task = taskService.updateTask(id, requestDTO);

    if (task == null) {
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(task);
}
@DeleteMapping("/tasks/{id}")
public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
    boolean deleted = taskService.deleteTask(id);

    if (!deleted) {
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.noContent().build();
}
}