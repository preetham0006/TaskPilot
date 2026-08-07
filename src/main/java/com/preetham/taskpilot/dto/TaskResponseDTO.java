//Data going out of the API
package com.preetham.taskpilot.dto;

import com.preetham.taskpilot.enums.Priority;
import com.preetham.taskpilot.enums.Status;
import com.preetham.taskpilot.enums.Category;
import java.time.LocalDate;

public class TaskResponseDTO {

    private Integer id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private Category category;
    private LocalDate dueDate;

    public TaskResponseDTO() {
    }

    public TaskResponseDTO(Integer id, String title, String description, Priority priority, Status status, Category category, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.category = category;
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}