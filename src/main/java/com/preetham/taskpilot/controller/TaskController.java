package com.preetham.taskpilot.controller;

import com.preetham.taskpilot.entity.Task;
import com.preetham.taskpilot.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import com.preetham.taskpilot.dto.PageResponseDTO;
import com.preetham.taskpilot.dto.TaskRequestDTO;
import com.preetham.taskpilot.dto.TaskResponseDTO;
import com.preetham.taskpilot.dto.TaskStatisticsDTO;
import com.preetham.taskpilot.dto.UpdateStatusDTO;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;


@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET /tasks
    @Operation(summary = "Retrieve all tasks")
    @GetMapping("/tasks")
    public PageResponseDTO<TaskResponseDTO> getAllTasks(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction) {

    return taskService.getAllTasks(page, size, sortBy, direction);
}

    // GET /tasks/{id}
    @Operation(summary = "Retrieve a task by ID")
    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Integer id) {

    TaskResponseDTO task = taskService.getTaskById(id);

    if (task == null) {
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(task);
}
@Operation(summary = "Create a new task")
@PostMapping("/tasks")
public TaskResponseDTO createTask(@Valid @RequestBody TaskRequestDTO requestDTO) {
    return taskService.createTask(requestDTO);
}
@Operation(summary = "Update an existing task")
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
@Operation(summary = "Delete a task")
@DeleteMapping("/tasks/{id}")
public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
    boolean deleted = taskService.deleteTask(id);

    if (!deleted) {
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.noContent().build();
}

@GetMapping("/tasks/search")
@Operation(summary = "Search tasks by title")
public PageResponseDTO<TaskResponseDTO> searchTasks(
        @RequestParam String title,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction) {

    return taskService.searchTasks(title, page, size, sortBy, direction);
}
@GetMapping("/tasks/stats")
@Operation(summary = "Get task statistics")
public TaskStatisticsDTO getTaskStatistics() {

    return taskService.getTaskStatistics();
}
@PatchMapping("/tasks/{id}/status")
@Operation(summary = "Update task status")
public TaskResponseDTO updateTaskStatus(
        @PathVariable Integer id,
        @Valid @RequestBody UpdateStatusDTO dto) {

    return taskService.updateTaskStatus(id, dto);
}
@GetMapping("/tasks/overdue")
@Operation(summary = "Get all overdue tasks")
public PageResponseDTO<TaskResponseDTO> getOverdueTasks(

        @RequestParam(defaultValue = "0") int page,

        @RequestParam(defaultValue = "5") int size,

        @RequestParam(defaultValue = "id") String sortBy,

        @RequestParam(defaultValue = "asc") String direction) {

    return taskService.getOverdueTasks(
            page,
            size,
            sortBy,
            direction
    );
}
}