package service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Task;
import model.TaskStatus;
import repository.TaskRepository;
import model.Priority;
import comparator.PriorityComparator;
import comparator.StatusComparator;
import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Optional;
import model.Category;
import java.util.Map;
import java.util.stream.Collectors;

//import java.util.Collections;
import java.util.Comparator;


public class TaskManager {

    // Stores all the tasks
    private List<Task> tasks; //encapsulation  
    private TaskRepository repository;

    
    public TaskManager() {
        repository = new TaskRepository();
        tasks = repository.findAll();
        
    }

    // Add a new task
    public void addTask(Task task) {

    if (repository.save(task)) {

        tasks.add(task);

        System.out.println("Task added successfully!");

    } else {

        System.out.println("Failed to add task!");

    }

}

    // Display all tasks
    public List<Task> getAllTasks() {

        return tasks;
    }

    // Find a task using its ID
public Task findTaskById(int id) {

        for (Task task : tasks) {

            if (task.getId() == id) {
                return task;
            }

        }

        return null;
    }

public boolean updateTaskStatus(int id, TaskStatus newStatus) {

    Task task = findTaskById(id);

    if (task != null && repository.updateTaskStatus(id, newStatus)) {

        task.setStatus(newStatus);

        return true;

    }

    return false;

}
public boolean deleteTask(int id) {

    Task task = findTaskById(id);

    if (task != null && repository.deleteTask(id)) { //If deleted in database, then delete from list

        tasks.remove(task);

        return true;

    }

    return false;

}
public List<Task> searchByPriority(Priority priority)
    {
        return filterTasks(task -> task.getPriority() == priority);
    }
public List<Task> searchByStatus(TaskStatus status)
    {
        return filterTasks(task -> task.getStatus() == status);
    }
public List<Task> searchByCategory(Category category) {

    return filterTasks(task -> task.getCategory() == category);

}

public List<Task> sortByPriority() {

    return tasks.stream()
            .sorted(Comparator.comparing(Task::getPriority))
            .toList();

}
public List<Task> sortByStatus() {

    return tasks.stream()
            .sorted(Comparator.comparing(Task::getStatus))
            .toList();

}
public List<Task> sortByTitle() {

    return tasks.stream()
            .sorted(Comparator.comparing(Task::getTitle))
            .toList();

}
public List<Task> sortByCategory() {

    return tasks.stream()
            .sorted(Comparator.comparing(Task::getCategory))
            .toList();

}
public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
}
public List<Task> getOverdueTasks() {

    LocalDate today = LocalDate.now();

    return filterTasks(task ->
            task.getDueDate().isBefore(today)
            && task.getStatus() != TaskStatus.COMPLETED);

}
public List<Task> getTasksDueToday() {

    //List<Task> dueToday = new ArrayList<>();

    LocalDate today = LocalDate.now();

   
    
   return filterTasks(task-> task.getDueDate().isEqual(today)
            && task.getStatus() != TaskStatus.COMPLETED);

    
}
public List<Task> getUpcomingTasks() {

    LocalDate today = LocalDate.now();

    return filterTasks(task-> task.getDueDate().isAfter(today)
            && task.getStatus() != TaskStatus.COMPLETED);
}
public List<Task> sortByDueDate() {

    return tasks.stream()
            .sorted(Comparator.comparing(Task::getDueDate))
            .toList();

}
public int getTotalTasks() {
    return tasks.size();
}
public int getCompletedTaskCount() {

    return (int) tasks.stream()
            .filter(task -> task.getStatus() == TaskStatus.COMPLETED)
            .count();

}
public int getPendingTaskCount() {
    return (int) tasks.stream()
            .filter(task -> task.getStatus() != TaskStatus.COMPLETED)
            .count();
}
public int getOverdueTaskCount() {

    return getOverdueTasks().size();

}
public int getDueTodayTaskCount() { //todays

    return getTasksDueToday().size();

}
public int getUpcomingTaskCount() {

    return getUpcomingTasks().size();

}
public List<Task> getTasksDueThisWeek() {

    LocalDate today = LocalDate.now();
    LocalDate nextWeek = today.plusDays(7);

    return filterTasks(task-> !task.getDueDate().isBefore(today)
            && !task.getDueDate().isAfter(nextWeek)
            && task.getStatus() != TaskStatus.COMPLETED);
}
public List<Task> searchByDueDate(LocalDate dueDate) 
{

    return filterTasks(task -> task.getDueDate().isEqual(dueDate));

}
private List<Task> filterTasks(Predicate<Task> condition) {

    return tasks.stream()                   //Stream created here
            .filter(condition)
            .collect(Collectors.toList()); //Arraylist list created inside this (collect)

}
public List<String> getAllTaskTitles() {

    return tasks.stream()
            .map(Task::getTitle)
            .toList();
}
public boolean hasOverdueTasks() {

    LocalDate today = LocalDate.now();

    return tasks.stream()
            .anyMatch(task ->
                    task.getDueDate().isBefore(today)
                    && task.getStatus() != TaskStatus.COMPLETED);

}
public Optional<Task> getFirstOverdueTask() {

    LocalDate today = LocalDate.now();

    return tasks.stream()
            .filter(task ->
                    task.getDueDate().isBefore(today)
                    && task.getStatus() != TaskStatus.COMPLETED)
            .findFirst();

}
public List<Task> sortByDueDateStream() {

    return tasks.stream()
            .sorted(Comparator.comparing(Task::getDueDate))
            .toList();
}
public Map<Category, Long> getCategoryStatistics() {

    return tasks.stream()
            .collect(Collectors.groupingBy(
                    Task::getCategory,
                    Collectors.counting()
            ));

}
public Map<Priority, Long> getPriorityStatistics() {

    return tasks.stream()
            .collect(Collectors.groupingBy(
                    Task::getPriority,
                    Collectors.counting()
            ));

}
public Map<TaskStatus, Long> getStatusStatistics() {

    return tasks.stream()
            .collect(Collectors.groupingBy(
                    Task::getStatus,
                    Collectors.counting()
            ));

}
public double getCompletionPercentage() {

    if (tasks.isEmpty()) {
        return 0.0;
    }

    return (getCompletedTaskCount() * 100.0) / tasks.size();

}
}