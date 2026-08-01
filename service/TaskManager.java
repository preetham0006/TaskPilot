package service;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Task;
import model.TaskStatus;
import model.Priority;
import comparator.PriorityComparator;
import comparator.StatusComparator;
import java.time.LocalDate;

//import java.util.Collections;
import java.util.Comparator;

public class TaskManager {

    // Stores all the tasks
    private List<Task> tasks; //encapsulation  

    // Constructor
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Add a new task
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    // Display all tasks
    public List<Task> getAllTasks() {

        return tasks;

        /*if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n========= TASK LIST =========");

        for (Task task : tasks) {
            System.out.println(task);
        }*/
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

    // Update task status
    public boolean updateTaskStatus(int id, TaskStatus newStatus) {

        Task task = findTaskById(id);

        if (task != null) {
            task.setStatus(newStatus);
            return true;
        }

        return false;
    }

    // Delete a task
    public boolean deleteTask(int id) {

        Task task = findTaskById(id);

        if (task != null) {
            tasks.remove(task);
            return true;
        }

        return false;
    }
    public List<Task> searchByPriority(Priority priority)
    {
        List<Task> result = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                result.add(task);
            }
        }

        return result;
    }
    public List<Task> searchByStatus(TaskStatus status)
    {
        List<Task> result = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getStatus() == status) {
                result.add(task);
            }
        }

        return result;
    }
    public List<Task> sortByPriority() {
    List<Task> sortedTasks = new ArrayList<>(tasks);

    // Sort the copied list
    sortedTasks.sort(
    new PriorityComparator()
        .thenComparing(
            Comparator.comparing(
                Task::getTitle,
                String.CASE_INSENSITIVE_ORDER
            )
        )
);


    return sortedTasks;
}
public List<Task> sortByStatus() {

    List<Task> sortedTasks = new ArrayList<>(tasks);

    sortedTasks.sort(
    new StatusComparator()
        .thenComparing(
            Comparator.comparing(
                Task::getTitle,
                String.CASE_INSENSITIVE_ORDER
            )
        )
);

    return sortedTasks;
}
public List<Task> sortByTitle() {

    List<Task> sortedTasks = new ArrayList<>(tasks);

    sortedTasks.sort(
    Comparator.comparing(Task::getTitle, String.CASE_INSENSITIVE_ORDER));
   // Collections.sort(sortedTasks,
   // (task1, task2) -> task1.getTitle().compareToIgnoreCase(task2.getTitle()));

    return sortedTasks;
}
public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
}
public List<Task> getOverdueTasks() {

    List<Task> overdueTasks = new ArrayList<>();

    LocalDate today = LocalDate.now();

    for (Task task : tasks) {

        if (task.getDueDate().isBefore(today)
                && task.getStatus() != TaskStatus.COMPLETED) {

            overdueTasks.add(task);

        }

    }

    return overdueTasks;
}
public List<Task> getTasksDueToday() {

    List<Task> dueToday = new ArrayList<>();

    LocalDate today = LocalDate.now();

    for (Task task : tasks) {

        if (task.getDueDate().isEqual(today)
                && task.getStatus() != TaskStatus.COMPLETED) {

            dueToday.add(task);

        }

    }

    return dueToday;
}
public List<Task> getUpcomingTasks() {

    List<Task> upcomingTasks = new ArrayList<>();

    LocalDate today = LocalDate.now();

    for (Task task : tasks) {

        if (task.getDueDate().isAfter(today)
                && task.getStatus() != TaskStatus.COMPLETED) {

            upcomingTasks.add(task);

        }

    }

    return upcomingTasks;
}
public List<Task> sortByDueDate() {

    List<Task> sortedTasks = new ArrayList<>(tasks);

    sortedTasks.sort(
            Comparator.comparing(Task::getDueDate)
    );

    return sortedTasks;
}
public int getTotalTasks() {
    return tasks.size();
}
public int getCompletedTaskCount() {

    int count = 0;

    for (Task task : tasks) {

        if (task.getStatus() == TaskStatus.COMPLETED) {
            count++;
        }

    }

    return count;
}
public int getPendingTaskCount() {

    int count = 0;

    for (Task task : tasks) {

        if (task.getStatus() != TaskStatus.COMPLETED) {
            count++;
        }

    }

    return count;
}
public int getOverdueTaskCount() {

    return getOverdueTasks().size();

}
public int getDueTodayTaskCount() {

    return getTasksDueToday().size();

}
public int getUpcomingTaskCount() {

    return getUpcomingTasks().size();

}
public List<Task> getTasksDueThisWeek() {

    List<Task> weeklyTasks = new ArrayList<>();

    LocalDate today = LocalDate.now();
    LocalDate nextWeek = today.plusDays(7);

    for (Task task : tasks) {

        if (!task.getDueDate().isBefore(today)
                && !task.getDueDate().isAfter(nextWeek)
                && task.getStatus() != TaskStatus.COMPLETED) {

            weeklyTasks.add(task);
        }
    }

    return weeklyTasks;
}
public List<Task> searchByDueDate(LocalDate dueDate) {

    List<Task> result = new ArrayList<>();

    for (Task task : tasks) {

        if (task.getDueDate().isEqual(dueDate)) {

            result.add(task);

        }

    }

    return result;
}
}