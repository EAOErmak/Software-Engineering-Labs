package com.example.springbootdemo.services;

import com.example.springbootdemo.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Task> getAll() {
        return tasks;
    }

    public Task getById(Long id) {
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public void add(Task task) {
        task.setId(idCounter++);
        tasks.add(task);
    }

    public void update(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(task.getId())) {
                tasks.set(i, task);
                return;
            }
        }
    }

    public void delete(Long id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }
}
