package storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import model.Task;

public class FileStorage {

    private static final String FILE_NAME = "tasks.txt";

    public void saveTasks(List<Task> tasks) {
        System.out.println("saveTasks() called");

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
}