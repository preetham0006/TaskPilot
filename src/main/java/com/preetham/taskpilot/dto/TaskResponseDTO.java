//Data going out of the API
package com.preetham.taskpilot.dto;

public class TaskResponseDTO {

    private Integer id;
    private String title;

    public TaskResponseDTO() {
    }

    public TaskResponseDTO(Integer id, String title) {
        this.id = id;
        this.title = title;
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
}