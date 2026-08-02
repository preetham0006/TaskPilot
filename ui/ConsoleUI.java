package ui;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import model.Task;
import model.Priority;
import model.TaskStatus;
import service.TaskManager;
import storage.FileStorage;
import java.time.LocalDate;
import model.Category;




public class ConsoleUI {

    private Scanner sc;
    private TaskManager manager;
    private FileStorage fileStorage = new FileStorage();
    private Category category; 
    

    public ConsoleUI() {
        sc = new Scanner(System.in);
        manager = new TaskManager();
        manager.setTasks(fileStorage.loadTasks());
       // System.out.println(manager.getCategoryStatistics());
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
    System.out.println("12. Display Overdue Tasks");
    System.out.println("13. Display Tasks Due Today");
    System.out.println("14. Display Upcoming Tasks");
    System.out.println("15. Sort Tasks by Due Date");
    System.out.println("16. Display Tasks Due This Week");
    System.out.println("17. Search Tasks by Due Date");
    System.out.println("18. Search Tasks by Category");
    System.out.println("19. Sort Tasks by Category");
    System.out.println("20. Display Task Statistics");
    //System.out.println("==================================");
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
System.out.println("Select Category:"); //cateogory selection

Category[] categories = Category.values();

for (int i = 0; i < categories.length; i++) {
    System.out.println((i + 1) + ". " + categories[i]);
}

System.out.print("Enter Category: ");
int categoryChoice = Integer.parseInt(sc.nextLine());

Category category = categories[categoryChoice - 1];

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

                    System.out.print("Enter Due Date (YYYY-MM-DD): ");
                    String dueDateInput = sc.nextLine();

                    LocalDate dueDate = LocalDate.parse(dueDateInput);

                    Task task = new Task(
                                title,
                                description,
                                priority,
                                status,
                                dueDate,
                                category
                    );

                    manager.addTask(task);
                    fileStorage.saveTasks(manager.getAllTasks()); //autosave

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

                        fileStorage.saveTasks(manager.getAllTasks()); //autosave
                        System.out.println("Task updated successfully.");

                        } 
                        else {

                                System.out.println("Task not found.");
                        }
    }

    private void deleteTask()

    {
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = sc.nextInt();

                    if (manager.deleteTask(deleteId)) {

    fileStorage.saveTasks(manager.getAllTasks());

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
private void showOverdueTasks() {

    List<Task> overdueTasks = manager.getOverdueTasks();

    if (overdueTasks.isEmpty()) {
        System.out.println("No overdue tasks.");
        return;
    }

    for (Task task : overdueTasks) {
        System.out.println(task);
    }
}
private void showTasksDueToday() {

    List<Task> dueToday = manager.getTasksDueToday();

    if (dueToday.isEmpty()) {
        System.out.println("No tasks due today.");
        return;
    }

    for (Task task : dueToday) {
        System.out.println(task);
    }
}
private void showUpcomingTasks() {

    List<Task> upcomingTasks = manager.getUpcomingTasks();

    if (upcomingTasks.isEmpty()) {
        System.out.println("No upcoming tasks.");
        return;
    }

    for (Task task : upcomingTasks) {
        System.out.println(task);
    }
}
private void sortTasksByDueDate() {

    List<Task> sortedTasks = manager.sortByDueDate();

    if (sortedTasks.isEmpty()) {
        System.out.println("No tasks available.");
        return;
    }

    for (Task task : sortedTasks) {
        System.out.println(task);
    }
}
private void displayDashboard() {

    System.out.println("\n====================================");
    System.out.println("          TASK DASHBOARD");
    System.out.println("====================================");

    System.out.println("Total Tasks : " + manager.getTotalTasks());

    System.out.println("Completed   : " + manager.getCompletedTaskCount());

    System.out.println("Pending     : " + manager.getPendingTaskCount());

    System.out.println("Overdue     : " + manager.getOverdueTaskCount());

    System.out.println("Due Today   : " + manager.getDueTodayTaskCount());

    System.out.println("Upcoming    : " + manager.getUpcomingTaskCount());

    System.out.println("====================================\n");
}
private void showTasksDueThisWeek() {

    List<Task> weeklyTasks = manager.getTasksDueThisWeek();

    if (weeklyTasks.isEmpty()) {
        System.out.println("No tasks due this week.");
        return;
    }

    for (Task task : weeklyTasks) {
        System.out.println(task);
    }
}
private void searchByDueDate() {

    System.out.print("Enter Due Date (YYYY-MM-DD): ");

    LocalDate dueDate = LocalDate.parse(sc.nextLine());

    List<Task> tasks = manager.searchByDueDate(dueDate);

    if (tasks.isEmpty()) {

        System.out.println("No tasks found.");

        return;

    }

    for (Task task : tasks) {

        System.out.println(task);

    }

}
private void displayStatistics() {

    System.out.println("\n========== TASK STATISTICS ==========\n");

    System.out.println("Tasks by Category");
    manager.getCategoryStatistics()
            .forEach((category, count) ->
                    System.out.println(category + " : " + count));

    System.out.println("\nTasks by Priority");
    manager.getPriorityStatistics()
            .forEach((priority, count) ->
                    System.out.println(priority + " : " + count));

    System.out.println("\nTasks by Status");
    manager.getStatusStatistics()
            .forEach((status, count) ->
                    System.out.println(status + " : " + count));

    System.out.printf("\nCompletion Percentage : %.2f%%\n",
            manager.getCompletionPercentage());

    System.out.println("\n====================================");
}
    public void start() {
         boolean running = true;
        
        while (running) {
            displayDashboard();
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
                
                case 12:
                    showOverdueTasks();
                    break;

                case 13:
                    showTasksDueToday();
                    break;

                case 14:
                    showUpcomingTasks();
                    break;
                
                case 15:
                    sortTasksByDueDate();
                    break;

                case 16:
                    showTasksDueThisWeek();
                    break;
                
                case 17:
                    searchByDueDate();
                    break;

                case 18:

                    System.out.println("Select Category:");
                    Category[] categories = Category.values();
                    for (int i = 0; i < categories.length; i++) {
                        System.out.println((i + 1) + ". " + categories[i]);
                    }

                    System.out.print("Enter Category: ");
                    int categoryChoice = Integer.parseInt(sc.nextLine());

                    Category category = categories[categoryChoice - 1];

                    displayTasks(manager.searchByCategory(category));

                    break;

                case 19:
                    displayTasks(manager.sortByCategory());
                    break;
                
                case 20:
                    displayStatistics();
                    break;

                default:

                    System.out.println("Invalid Choice! Please try again.");
            }
        }

        sc.close();
    }

}