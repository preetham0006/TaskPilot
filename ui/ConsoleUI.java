package ui;
import java.util.Scanner;
import java.util.List;
import model.Task;
import model.Priority;
import model.TaskStatus;
import service.TaskManager;
import storage.FileStorage;



public class ConsoleUI {

    private Scanner sc;
    private TaskManager manager;
    private FileStorage fileStorage = new FileStorage();
    

    public ConsoleUI() {
        sc = new Scanner(System.in);
        manager = new TaskManager();
        manager.setTasks(fileStorage.loadTasks());
    }
    private void displayMenu() 
    
    {
    System.out.println("\n====================================");
    System.out.println("      TASK MANAGEMENT SYSTEM");
    System.out.println("====================================");
    System.out.println("1. Add Task");
    System.out.println("2. Display All Tasks");
    System.out.println("3. Find Task by ID");
    System.out.println("4. Search by Priority");
    System.out.println("5. Search by Status");
    System.out.println("6. Update Task Status");
    System.out.println("7. Delete Task");
    System.out.println("8. Exit");
    System.out.println("9. Sort Tasks by Priority");
    System.out.println("10. Sort Tasks by Status");
    System.out.println("11. Sort Tasks by Title");
    System.out.print("\nEnter your choice: ");
    }

    private void addTask()
    
    {
        System.out.print("Enter Task Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String description = sc.nextLine();

                    System.out.println("Select Priority:");
                    System.out.println("1. LOW");
                    System.out.println("2. MEDIUM");
                    System.out.println("3. HIGH");
                    

                    int priorityChoice = sc.nextInt();
                    sc.nextLine();

                    Priority priority;

                    switch (priorityChoice) {
                        case 1:
                            priority = Priority.LOW;
                            break;
                        case 2:
                            priority = Priority.MEDIUM;
                            break;
                        case 3:
                            priority = Priority.HIGH;
                            break;
                        default:
                            System.out.println("Invalid Priority! Setting to LOW.");
                            priority = Priority.LOW;
                    }
                    System.out.println("Select Status:");
System.out.println("1. TODO");
System.out.println("2. IN_PROGRESS");
System.out.println("3. COMPLETED");

int statusChoice = sc.nextInt();
sc.nextLine();

TaskStatus status;

switch (statusChoice) {
    case 1:
        status = TaskStatus.TODO;
        break;
    case 2:
        status = TaskStatus.IN_PROGRESS;
        break;
    case 3:
        status = TaskStatus.COMPLETED;
        break;
    default:
        System.out.println("Invalid Status! Setting to TODO."); 
        status = TaskStatus.TODO;
}

                    Task task = new Task(
                            title,
                            description,
                            priority,
                            status
                    );

                    manager.addTask(task);

    }

    private void displayAllTasks()
    
    {
       List<Task> tasks = manager.getAllTasks();

      displayTasks(tasks);
    }

    private void findTaskById()

    {
        System.out.print("Enter Task ID: ");
        int findId = sc.nextInt();
        Task foundTask = manager.findTaskById(findId);
        if (foundTask != null) {
                System.out.println(foundTask);        
            } else {
                System.out.println("Task not found.");
                }
    }

    private void updateTaskStatus()

    {
                    System.out.print("Enter Task ID: ");
                    int updateId = sc.nextInt();

                    System.out.println("Choose New Status:");
                    System.out.println("1. TODO");
                    System.out.println("2. IN_PROGRESS");
                    System.out.println("3. COMPLETED");

                    int statusChoice = sc.nextInt();

                    TaskStatus newStatus;

                    switch (statusChoice) {
                        case 1:
                            newStatus = TaskStatus.TODO;
                            break;
                        case 2:
                            newStatus = TaskStatus.IN_PROGRESS;
                            break;
                        case 3:
                            newStatus = TaskStatus.COMPLETED;
                            break;
                        default:
                            System.out.println("Invalid Status!");
                            return;
                    }

                    if (manager.updateTaskStatus(updateId, newStatus)) {
                        System.out.println("Task updated successfully.");
                    } else {
                        System.out.println("Task not found.");
                    }
    }

    private void deleteTask()

    {
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = sc.nextInt();

                    if (manager.deleteTask(deleteId)) {
                        System.out.println("Task deleted successfully.");
                    } else {
                        System.out.println("Task not found.");
                    }
    }
    
    private void searchByPriority() {
        System.out.println("Select Priority to Search:");
        System.out.println("1. LOW");
        System.out.println("2. MEDIUM");
        System.out.println("3. HIGH");

        int priorityChoice = sc.nextInt();
        sc.nextLine(); // Consume newline

        Priority priority;

        switch (priorityChoice) {
            case 1:
                priority = Priority.LOW;
                break;
            case 2:
                priority = Priority.MEDIUM;
                break;
            case 3:
                priority = Priority.HIGH;
                break;
            default:
                System.out.println("Invalid Priority!");
                return;
        }

       displayAllTasks();
    }
    private void searchByStatus() {
        System.out.println("Select Status to Search:");
        System.out.println("1. TODO");
        System.out.println("2. IN_PROGRESS");
        System.out.println("3. COMPLETED");

        int statusChoice = sc.nextInt();
        sc.nextLine(); // Consume newline

        TaskStatus status;

        switch (statusChoice) {
            case 1:
                status = TaskStatus.TODO;
                break;
            case 2:
                status = TaskStatus.IN_PROGRESS;
                break;
            case 3:
                status = TaskStatus.COMPLETED;
                break;
            default:
                System.out.println("Invalid Status!");
                return;
        }

        List<Task> tasks = manager.searchByStatus(status);

        displayTasks(tasks);
    }

    private void displayTasks(List<Task> tasks) {

    if (tasks.isEmpty()) {
        System.out.println("No tasks found.");
        return;
    }

    for (Task task : tasks) {
        System.out.println(task);
    }

}

private void sortTasksByPriority() {

    List<Task> tasks = manager.getAllTasks();

    if (tasks.isEmpty()) {
        System.out.println("No tasks available to sort.");
        return;
    }

    List<Task> sortedTasks = manager.sortByPriority();
    displayTasks(sortedTasks);
} 

private void sortTasksByStatus()

{

    List<Task> tasks = manager.getAllTasks();

    if (tasks.isEmpty()) {
        System.out.println("No tasks available to sort.");
        return;
    }

    List<Task> sortedTasks = manager.sortByStatus();

    displayTasks(sortedTasks);
}
private void sortTasksByTitle() {

    List<Task> tasks = manager.getAllTasks();

    if (tasks.isEmpty()) {
        System.out.println("No tasks available to sort.");
        return;
    }

    List<Task> sortedTasks = manager.sortByTitle();

    displayTasks(sortedTasks);
}


    public void start() {
         boolean running = true;

        while (running) {

            displayMenu(); // prints the menu

            int option = sc.nextInt(); //collecting option
            sc.nextLine(); // Consume newline

            switch (option) {

                case 1:
                    addTask();
                    break;

                case 2:

                    displayAllTasks();
                    break;

                case 3:

                    findTaskById();
                    break;
                case 4:

                    searchByPriority();
                    break;

                case 5:

                    searchByStatus();
                    break;
                case 6:

                    updateTaskStatus();
                    break;

                case 7:

                    deleteTask();
                    break;

                case 8:

                    fileStorage.saveTasks(manager.getAllTasks());
                    System.out.println("Tasks saved successfully!");

                    running = false;
                    System.out.println("\nThank you for using Task Management System!");
                    break;
                case 9:
                    sortTasksByPriority();
                    break;   
                case 10:
                    sortTasksByStatus();
                    break;    
                case 11:     
                    sortTasksByTitle();
                    break;

                default:

                    System.out.println("Invalid Choice! Please try again.");
            }
        }

        sc.close();
    }

}