import java.util.Scanner;
import java.util.List;


public class ConsoleUI {

    private Scanner sc;
    private TaskManager manager;

    public ConsoleUI() {
        sc = new Scanner(System.in);
        manager = new TaskManager();
    }
    private void displayMenu() 
    
    {
    System.out.println("\n====================================");
    System.out.println("      TASK MANAGEMENT SYSTEM");
    System.out.println("====================================");
    System.out.println("1. Add Task");
    System.out.println("2. Display All Tasks");
    System.out.println("3. Find Task by ID");
    System.out.println("4. Update Task Status");
    System.out.println("5. Delete Task");
    System.out.println("6. Exit");
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

                    Task task = new Task(
                            title,
                            description,
                            priority,
                            TaskStatus.TODO
                    );

                    manager.addTask(task);

    }

    private void displayAllTasks()
    
    {
       List<Task> tasks = manager.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
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
                            continue;
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

                    updateTaskStatus();
                    break;

                case 5:

                    deleteTask();
                    break;

                case 6:

                    running = false;
                    System.out.println("\nThank you for using Task Management System!");

                    break;

                default:

                    System.out.println("Invalid Choice! Please try again.");
            }
        }

        sc.close();
    }

}