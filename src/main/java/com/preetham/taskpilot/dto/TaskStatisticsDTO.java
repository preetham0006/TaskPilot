package com.preetham.taskpilot.dto;

public class TaskStatisticsDTO {

    private long totalTasks;
    private long completedTasks;
    private long pendingTasks;
    private long inProgressTasks;
    private long highPriorityTasks;
    private long overdueTasks;

    public TaskStatisticsDTO() {
    }

    public TaskStatisticsDTO(long totalTasks,
                             long completedTasks,
                             long pendingTasks,
                             long inProgressTasks,
                             long highPriorityTasks,
                             long overdueTasks) {
        this.totalTasks = totalTasks;
        this.completedTasks = completedTasks;
        this.pendingTasks = pendingTasks;
        this.inProgressTasks = inProgressTasks;
        this.highPriorityTasks = highPriorityTasks;
        this.overdueTasks = overdueTasks;
    }

    // Generate getters and setters
    public long getTotalTasks() {
        return totalTasks;
    }

    public long getCompletedTasks() {
        return completedTasks;
    }

    public long getPendingTasks() {
        return pendingTasks;
    }

    public long getInProgressTasks() {
        return inProgressTasks;
    }

    public long getHighPriorityTasks() {
        return highPriorityTasks;
    }

    public long getOverdueTasks() {
        return overdueTasks;
    }
    
}