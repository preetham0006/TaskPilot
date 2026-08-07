package com.preetham.taskpilot.mapper;

import com.preetham.taskpilot.dto.TaskRequestDTO;
import com.preetham.taskpilot.dto.TaskResponseDTO;
import com.preetham.taskpilot.entity.Task;
import com.preetham.taskpilot.enums.Priority;
import com.preetham.taskpilot.enums.Status;
import com.preetham.taskpilot.enums.Category;
public class TaskMapper {

    public static Task toEntity(TaskRequestDTO dto) {

        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        task.setStatus(dto.getStatus());
        task.setCategory(dto.getCategory());
        task.setDueDate(dto.getDueDate());
        return task;
    }

    public static TaskResponseDTO toResponseDTO(Task task) {

        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getStatus(),
                task.getCategory(),
                task.getDueDate()
        );
    }
}