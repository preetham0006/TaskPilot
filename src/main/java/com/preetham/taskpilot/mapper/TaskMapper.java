package com.preetham.taskpilot.mapper;

import com.preetham.taskpilot.dto.TaskRequestDTO;
import com.preetham.taskpilot.dto.TaskResponseDTO;
import com.preetham.taskpilot.entity.Task;

public class TaskMapper {

    public static Task toEntity(TaskRequestDTO dto) {

        Task task = new Task();
        task.setTitle(dto.getTitle());

        return task;
    }

    public static TaskResponseDTO toResponseDTO(Task task) {

        return new TaskResponseDTO(
                task.getId(),
                task.getTitle()
        );
    }
}