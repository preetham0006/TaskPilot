package com.preetham.taskpilot.dto;

import com.preetham.taskpilot.enums.Status;
import jakarta.validation.constraints.NotNull;

public class UpdateStatusDTO {

    @NotNull(message = "Status is required")
    private Status status;

    public UpdateStatusDTO() {
    }

    public UpdateStatusDTO(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}