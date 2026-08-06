package com.preetham.taskpilot.service;

import com.preetham.taskpilot.entity.Task;
import com.preetham.taskpilot.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {

        return repository.findAll();

    }
    public Task getTaskById(Integer id) {

    return repository.findById(id)
            .orElse(null);

}
public Task createTask(Task task) {

    return repository.save(task);
 // save returns the task because it is a JPA repository, which returns the saved entity after persisting it to the database.
}
public Task updateTask(Integer id, Task updatedTask) {
    Task existingTask = getTaskById(id);
    if (existingTask == null) {
        return null; 
    }
    existingTask.setTitle(updatedTask.getTitle());
        return repository.save(existingTask);
}
public boolean deleteTask(Integer id){
    
    Task existingTask = getTaskById(id);
    if (existingTask == null) {
        return false; 
    }
    repository.delete(existingTask);
    return true;
}
}