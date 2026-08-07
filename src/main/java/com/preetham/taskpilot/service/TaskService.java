package com.preetham.taskpilot.service;

import com.preetham.taskpilot.entity.Task;
import com.preetham.taskpilot.repository.TaskRepository;
import org.springframework.stereotype.Service;
import com.preetham.taskpilot.dto.TaskRequestDTO;
import com.preetham.taskpilot.dto.TaskResponseDTO;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskResponseDTO> getAllTasks() {

    List<Task> tasks = repository.findAll();

    return tasks.stream()           //stream() converts the list of tasks into a stream.
            .map(task -> new TaskResponseDTO(    //map () transforms each task into a TaskResponseDTO.
                    task.getId(),
                    task.getTitle()))
            .toList();
}

public TaskResponseDTO getTaskById(Integer id) {

    Task task = repository.findById(id).orElse(null);

    if (task == null) {
        return null;
    }

    return new TaskResponseDTO(
            task.getId(),
            task.getTitle()
    );
}
public TaskResponseDTO createTask(TaskRequestDTO requestDTO) {

    Task task = new Task();
    task.setTitle(requestDTO.getTitle());

    Task savedTask = repository.save(task);

    return new TaskResponseDTO(
            savedTask.getId(),
            savedTask.getTitle()
    );
}
public TaskResponseDTO updateTask(Integer id, TaskRequestDTO requestDTO) {

    Task existingTask = repository.findById(id).orElse(null);

    if (existingTask == null) {
        return null;
    }

    existingTask.setTitle(requestDTO.getTitle());

    Task updatedTask = repository.save(existingTask);

    return new TaskResponseDTO(
            updatedTask.getId(),
            updatedTask.getTitle()
    );
}
public boolean deleteTask(Integer id) {

    Task existingTask = repository.findById(id).orElse(null);

    if (existingTask == null) {
        return false;
    }

    repository.delete(existingTask);

    return true;
}
}