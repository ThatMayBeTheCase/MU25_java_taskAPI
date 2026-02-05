package com.example.taskAPI.controller;

import com.example.taskAPI.model.Task;
import com.example.taskAPI.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @PostMapping("/tasks")
    public String addTask(@Valid @RequestBody Task task) {

        repository.save(task);
        return "Task added";
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable int id) {
        repository.delete(id);
        return "task deleted";
    }

    @PatchMapping("/tasks/{id}")
    public String patchTask( @PathVariable int id , @RequestBody Task updates) {
        Task task = repository.findById(id);

        if (task == null) {
            return "Task not found";
        }

        if (updates.getName() != null) {
            task.setName(updates.getName());
        }

        if (updates.isDone() != null ) {
            task.setDone(updates.isDone());
        }

        return "Task: " + id + " updated";
    }



}
