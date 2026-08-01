package storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import model.Priority;
import model.Task;
import model.TaskStatus;
import java.time.LocalDate;

public class FileStorage {

    private static final String FILE_NAME = "tasks.txt";

    public void saveTasks(List<Task> tasks) {
        //System.out.println("saveTasks() called");

        List<String> lines = new ArrayList<>();

        for (Task task : tasks) {

            String line =
                    task.getId() + "|" +
                    task.getTitle() + "|" +
                    task.getDescription() + "|" +
                    task.getPriority() + "|" +
                    task.getStatus()+ "|" +
                    task.getDueDate();

            lines.add(line);
        }

        try {
            Files.write(Path.of(FILE_NAME), lines);
           
        } catch (IOException e) {
    System.out.println("Error: Unable to save tasks.");
}
    }
    public List<Task> loadTasks() {

    List<Task> tasks = new ArrayList<>();
    if (!Files.exists(Path.of(FILE_NAME))) {
    return tasks;
}
    try {
        

        List<String> lines = Files.readAllLines(Path.of(FILE_NAME));
       /*  for (String line : lines) {
    System.out.println(line);
}*/
        for (String line : lines) {

    String[] parts = line.split("\\|");

   Task task = new Task(
        Integer.parseInt(parts[0]),
        parts[1],
        parts[2],
        Priority.valueOf(parts[3]),
        TaskStatus.valueOf(parts[4]),
        LocalDate.parse(parts[5])
);

tasks.add(task);
}

    } catch (IOException e) {
    System.out.println("Error: Unable to load saved tasks.");
}
   //System.out.println("Loaded Tasks: " + tasks.size());
    return tasks;
}
}