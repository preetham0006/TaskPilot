package com.preetham.taskpilot.repository;

import com.preetham.taskpilot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
//task means the entity class and Integer is the type of the primary key of the entity class
}