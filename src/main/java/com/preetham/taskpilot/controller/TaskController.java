package com.preetham.taskpilot.controller;

import com.preetham.taskpilot.entity.Task;
import com.preetham.taskpilot.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET /tasks
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // GET /tasks/{id}
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {

        Task task = taskService.getTaskById(id);

        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }
@PostMapping("/tasks")
public Task createTask(@RequestBody Task task) {

    return taskService.createTask(task);

}
@PutMapping("/tasks/{id}")
public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task updatedTask) {
    Task task = taskService.updateTask(id, updatedTask);

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