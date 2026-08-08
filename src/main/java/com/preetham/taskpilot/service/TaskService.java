package com.preetham.taskpilot.service;

import com.preetham.taskpilot.entity.Task;
import com.preetham.taskpilot.mapper.TaskMapper;
import com.preetham.taskpilot.repository.TaskRepository;
import org.springframework.stereotype.Service;

import com.preetham.taskpilot.dto.PageResponseDTO;
import com.preetham.taskpilot.dto.TaskRequestDTO;
import com.preetham.taskpilot.dto.TaskResponseDTO;
import com.preetham.taskpilot.dto.TaskStatisticsDTO;
import com.preetham.taskpilot.dto.UpdateStatusDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import com.preetham.taskpilot.enums.Priority;
import com.preetham.taskpilot.enums.Status;
import com.preetham.taskpilot.enums.Category;
import com.preetham.taskpilot.exception.ResourceNotFoundException;

import org.springframework.data.jpa.domain.Specification;

import com.preetham.taskpilot.specification.TaskSpecification;

import java.time.LocalDate;
import java.util.List;
import com.preetham.taskpilot.enums.Status;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;


    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }
    private Pageable createPageable(
        int page,
        int size,
        String sortBy,
        String direction) {

    Sort sort = direction.equalsIgnoreCase("asc")
            ? Sort.by(sortBy).ascending()
            : Sort.by(sortBy).descending();

    return PageRequest.of(page, size, sort);
}

    public PageResponseDTO<TaskResponseDTO> getAllTasks(
        int page,
        int size,
        String sortBy,
        String direction) {

    Sort sort = direction.equalsIgnoreCase("asc")
            ? Sort.by(sortBy).ascending()
            : Sort.by(sortBy).descending();

    Pageable pageable = createPageable(page, size, sortBy, direction);

    Page<Task> tasks = repository.findAll(pageable);

    Page<TaskResponseDTO> taskDTOPage = tasks.map(TaskMapper::toResponseDTO);

    return PageResponseDTO.from(taskDTOPage);
}

public TaskResponseDTO getTaskById(Integer id) {

    Task task = repository.findById(id).orElse(null);

    if (task == null) {
        return null;
    }

    return TaskMapper.toResponseDTO(task);
}
public TaskResponseDTO createTask(TaskRequestDTO requestDTO) {

    Task task = TaskMapper.toEntity(requestDTO);
    Task savedTask = repository.save(task);
    return TaskMapper.toResponseDTO(savedTask);
}
public TaskResponseDTO updateTask(Integer id, TaskRequestDTO requestDTO) {

    Task existingTask = repository.findById(id).orElse(null);

    if (existingTask == null) {
        return null;
    }

    existingTask.setTitle(requestDTO.getTitle());
    existingTask.setDescription(requestDTO.getDescription());
    existingTask.setPriority(requestDTO.getPriority());
    existingTask.setStatus(requestDTO.getStatus());
    existingTask.setCategory(requestDTO.getCategory());
    existingTask.setDueDate(requestDTO.getDueDate());

    Task updatedTask = repository.save(existingTask);

    return TaskMapper.toResponseDTO(updatedTask);
}
public boolean deleteTask(Integer id) {

    Task existingTask = repository.findById(id).orElse(null);

    if (existingTask == null) {
        return false;
    }

    repository.delete(existingTask);

    return true;
}
public PageResponseDTO<TaskResponseDTO> searchTasks(
        String title,
        int page,
        int size,
        String sortBy,
        String direction) {

    Pageable pageable = createPageable(page, size, sortBy, direction);

    Page<Task> tasks =
            repository.findByTitleContainingIgnoreCase(title, pageable);

    Page<TaskResponseDTO> taskDTOPage =
            tasks.map(TaskMapper::toResponseDTO);

    return PageResponseDTO.from(taskDTOPage);
}
public TaskStatisticsDTO getTaskStatistics() {

    List<Task> tasks = repository.findAll();

    long totalTasks = tasks.size();

    long completedTasks = tasks.stream()
           .filter(task -> Status.COMPLETED.equals(task.getStatus()))
            .count();

    long pendingTasks = tasks.stream()
            .filter(task -> Status.TODO.equals(task.getStatus()))
            .count();

    long inProgressTasks = tasks.stream()
            .filter(task -> Status.IN_PROGRESS.equals(task.getStatus()))
            .count();

    long highPriorityTasks = tasks.stream()
            .filter(task -> Priority.HIGH.equals(task.getPriority()))
            .count();

long overdueTasks = tasks.stream()
        .filter(task ->
                task.getDueDate() != null &&
                task.getDueDate().isBefore(LocalDate.now()) &&
                task.getStatus() != Status.COMPLETED)
        .count();

    return new TaskStatisticsDTO(
            totalTasks,
            completedTasks,
            pendingTasks,
            inProgressTasks,
            highPriorityTasks,
            overdueTasks
    );
}
public TaskResponseDTO updateTaskStatus(Integer id, UpdateStatusDTO dto) {

    Task task = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

    task.setStatus(dto.getStatus());

    Task updatedTask = repository.save(task);

    return TaskMapper.toResponseDTO(updatedTask);
}
public PageResponseDTO<TaskResponseDTO> getOverdueTasks(
        int page,
        int size,
        String sortBy,
        String direction) {

    Pageable pageable = createPageable(page, size, sortBy, direction);

    Page<Task> tasks = repository.findByDueDateBeforeAndStatusNot(
            LocalDate.now(),
            Status.COMPLETED,
            pageable
    );

    Page<TaskResponseDTO> taskDTOPage = tasks.map(TaskMapper::toResponseDTO);

    return PageResponseDTO.from(taskDTOPage);
}
public PageResponseDTO<TaskResponseDTO> getTodayTasks(
        int page,
        int size,
        String sortBy,
        String direction) {

    Pageable pageable = createPageable(page, size, sortBy, direction);

    Page<Task> tasks = repository.findByDueDate(
            LocalDate.now(),
            pageable
    );

    Page<TaskResponseDTO> dtoPage = tasks.map(TaskMapper::toResponseDTO);

    return PageResponseDTO.from(dtoPage);
}
public PageResponseDTO<TaskResponseDTO> getUpcomingTasks(
        int page,
        int size,
        String sortBy,
        String direction) {

    Pageable pageable = createPageable(page, size, sortBy, direction);

    LocalDate today = LocalDate.now();
    LocalDate nextWeek = today.plusDays(7);

    Page<Task> tasks = repository.findByDueDateBetween(
            today,
            nextWeek,
            pageable
    );

    Page<TaskResponseDTO> dtoPage = tasks.map(TaskMapper::toResponseDTO);

    return PageResponseDTO.from(dtoPage);
}
public PageResponseDTO<TaskResponseDTO> filterTasks(
        Status status,
        Priority priority,
        Category category,
        String title,
        int page,
        int size,
        String sortBy,
        String direction) {

            Pageable pageable = createPageable(
            page,
            size,
            sortBy,
            direction);

    Specification<Task> specification = Specification.unrestricted();
    if (status != null) {

    specification = specification.and(
            TaskSpecification.hasStatus(status)
    );

    }
    if (priority != null) {
        specification = specification.and(
                TaskSpecification.hasPriority(priority)
        );
    }
    if (category != null) {
        specification = specification.and(
                TaskSpecification.hasCategory(category)
        );
    }
    if (title != null && !title.isBlank()) {
        specification = specification.and(
                TaskSpecification.titleContains(title)
        );
    }

    Page<Task> tasks = repository.findAll(specification, pageable);

    Page<TaskResponseDTO> dtoPage = tasks.map(TaskMapper::toResponseDTO);

    return PageResponseDTO.from(dtoPage);
}
}