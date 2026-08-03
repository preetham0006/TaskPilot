package repository;

import model.Category;
import model.Priority;
import model.Task;
import model.TaskStatus;

import java.time.LocalDate;

public class RepositoryTest {

    public static void main(String[] args) {

        TaskRepository repository = new TaskRepository();

        Task task = new Task(
                "Learn JDBC",
                "Insert first task into MySQL",
                Priority.HIGH,
                TaskStatus.TODO,
                LocalDate.now().plusDays(2),
                Category.STUDY
        );
       
        repository.save(task);
         System.out.println("\nTasks from Database:\n");

       /*  repository.findAll()
          .forEach(System.out::println);
        System.out.println("\nFinding Task with ID 1\n");*/

        Task foundTask = repository.findById(1);
        System.out.println(task);
        boolean updated =
        repository.updateTaskStatus(1,
                TaskStatus.COMPLETED);

        System.out.println(updated);
        System.out.println(repository.findById(1));
        System.out.println("\nDeleting Task 1...\n");

boolean deleted = repository.deleteTask(1);

System.out.println("Deleted : " + deleted);

System.out.println("\nRemaining Tasks\n");

repository.findAll()
          .forEach(System.out::println);


    }
    

}