package model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Task {

    // Shared counter for generating unique IDs
    private static int nextId = 1;

    // Fields
    private final int id;
    private String title;
    private String description;
    private Priority priority;
    private TaskStatus status;
    private LocalDate dueDate;

    // Default Constructor
    public Task() {
        this.id = nextId++;
    }

    // Parameterized Constructor
   public Task(String title,
            String description,
            Priority priority,
            TaskStatus status,
            LocalDate dueDate) {

    this.id = nextId++;
    this.title = title;
    this.description = description;
    this.priority = priority;
    this.status = status;
    this.dueDate = dueDate;
}
public Task(int id,
            String title,
            String description,
            Priority priority,
            TaskStatus status,
            LocalDate dueDate) {

    this.id = id;
    this.title = title;
    this.description = description;
    this.priority = priority;
    this.status = status;
    this.dueDate = dueDate;

    if (id >= nextId) {
        nextId = id + 1;
    }
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
    public LocalDate getDueDate() {
    return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
    }
    public long getDaysRemaining() {

    return ChronoUnit.DAYS.between(
            LocalDate.now(),
            dueDate
    );

}
public String getDueDateStatus() {

    long days = getDaysRemaining();

    if (status == TaskStatus.COMPLETED) {
        return "[Completed]";
    }

    if (days == 0) {
        return "[Due Today]";
    }

    if (days > 0) {
        return "[" + days + " day(s) remaining]";
    }

    return "[Overdue by " + Math.abs(days) + " day(s)]";
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
                "\n  Due Date = " + dueDate +
                "\n  " + getDueDateStatus() +
                "\n}";
    }
}