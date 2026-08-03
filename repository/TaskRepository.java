package repository;

import database.DatabaseConnection;
import model.Priority;
import model.Task;
import model.TaskStatus;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class TaskRepository {

    public boolean save(Task task) {

    String sql = """
            INSERT INTO tasks
            (title, description, priority, status, due_date, category)
            VALUES (?, ?, ?, ?, ?, ?) 
            """;
            //PreparedStatement prevents SQL injection attacks

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement =
                 connection.prepareStatement(sql)) {

        statement.setString(1, task.getTitle());
        statement.setString(2, task.getDescription());
        statement.setString(3, task.getPriority().name());
        statement.setString(4, task.getStatus().name());
        statement.setDate(5,
                java.sql.Date.valueOf(task.getDueDate()));
        statement.setString(6, task.getCategory().name());

       int rowsAffected = statement.executeUpdate();

       return rowsAffected > 0;

    } catch (Exception e) {

        e.printStackTrace();

    }

    return false;
}

public List<Task> findAll() {

    List<Task> tasks = new ArrayList<>();

    String sql = "SELECT * FROM tasks";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {

            Task task = new Task(

                    resultSet.getInt("id"),

                    resultSet.getString("title"),

                    resultSet.getString("description"),

                    Priority.valueOf(
                            resultSet.getString("priority")),

                    TaskStatus.valueOf(
                            resultSet.getString("status")),

                    resultSet.getDate("due_date")
                            .toLocalDate(),

                    Category.valueOf(
                            resultSet.getString("category"))

            );

            tasks.add(task);

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return tasks;

}
public Task findById(int id) {

    String sql = "SELECT * FROM tasks WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {

            return new Task(

                    resultSet.getInt("id"),

                    resultSet.getString("title"),

                    resultSet.getString("description"),

                    Priority.valueOf(resultSet.getString("priority")),

                    TaskStatus.valueOf(resultSet.getString("status")),

                    resultSet.getDate("due_date").toLocalDate(),

                    Category.valueOf(resultSet.getString("category"))

            );

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return null;

}
public boolean updateTaskStatus(int id, TaskStatus status) {

    String sql = """
            UPDATE tasks
            SET status = ?
            WHERE id = ?
            """;

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement =
                 connection.prepareStatement(sql)) {

        statement.setString(1, status.name());

        statement.setInt(2, id);

        int rowsAffected = statement.executeUpdate();

        return rowsAffected > 0;

    } catch (Exception e) {

        e.printStackTrace();

    }

    return false;

}
public boolean deleteTask(int id) {

    String sql = """
            DELETE FROM tasks
            WHERE id = ?
            """;

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement =
                 connection.prepareStatement(sql)) {

        statement.setInt(1, id);

        int rowsAffected = statement.executeUpdate();

        return rowsAffected > 0;

    } catch (Exception e) {

        e.printStackTrace();

    }

    return false;

}
}