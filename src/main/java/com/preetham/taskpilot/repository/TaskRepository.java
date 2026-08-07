package com.preetham.taskpilot.repository;

import com.preetham.taskpilot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.preetham.taskpilot.enums.Status;

public interface TaskRepository extends JpaRepository<Task, Integer> {
//task means the entity class and Integer is the type of the primary key of the entity class
Page<Task> findByTitleContainingIgnoreCase(String title, Pageable pageable);
Page<Task> findByDueDateBeforeAndStatusNot(
        LocalDate dueDate,
        Status status,
        Pageable pageable);
Page<Task> findByDueDate(
        LocalDate dueDate,
        Pageable pageable);
Page<Task> findByDueDateBetween(
        LocalDate startDate,
        LocalDate endDate,
        Pageable pageable);
}