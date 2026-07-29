public class Task {

    // Fields
    private int id;
    private String title;
    private String description;
    private Priority priority;
    private TaskStatus status;
    private static int nextId = 1;
    // Default Constructor
    public Task() {
    }

    // Parameterized Constructor
    public Task(int id, String title, String description,
                Priority priority, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Setter for ID
    public void setId(int id) {
        this.id = nextId++;
    }

    // Getter for Title
    public String getTitle() {
        return title;
    }

    // Setter for Title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for Description
    public String getDescription() {
        return description;
    }

    // Setter for Description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for Priority
    public Priority getPriority() {
        return priority;
    }

    // Setter for Priority
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    // Getter for Status
    public TaskStatus getStatus() {
        return status;
    }

    // Setter for Status
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    // toString Method
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}