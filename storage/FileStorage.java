package storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import model.Priority;
import model.Task;
import model.TaskStatus;

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
                    task.getStatus();

            lines.add(line);
        }

        try {
            Files.write(Path.of(FILE_NAME), lines);
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Task> loadTasks() {

    List<Task> tasks = new ArrayList<>();

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
        TaskStatus.valueOf(parts[4])
);

tasks.add(task);
}

    } catch (IOException e) {
        e.printStackTrace();
    }
   System.out.println("Loaded Tasks: " + tasks.size());
    return tasks;
}
}