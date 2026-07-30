package model;
public class Task {

    // Shared counter for generating unique IDs
    private static int nextId = 1;

    // Fields
    private final int id;
    private String title;
    private String description;
    private Priority priority;
    private TaskStatus status;

    // Default Constructor
    public Task() {
        this.id = nextId++;
    }

    // Parameterized Constructor
    public Task(String title, String description,
                Priority priority, TaskStatus status) {

        this.id = nextId++;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter and Setter for Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for Priority
    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    // Getter and Setter for Status
    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    // Print Task Details
    @Override
    public String toString() {
        return "Task {" +
                "\n  ID = " + id +
                "\n  Title = " + title +
                "\n  Description = " + description +
                "\n  Priority = " + priority +
                "\n  Status = " + status +
                "\n}";
    }
}