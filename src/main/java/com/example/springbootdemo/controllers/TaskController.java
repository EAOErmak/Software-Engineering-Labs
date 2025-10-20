package com.example.springbootdemo.controllers;

import com.example.springbootdemo.models.Task;
import com.example.springbootdemo.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/part2")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tasks", service.getAll());
        return "part2/tasks";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("task", new Task());
        return "part2/add-task";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Task task) {
        service.add(task);
        return "redirect:/part2";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("task", service.getById(id));
        return "part2/edit-task";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Task task) {
        service.update(task);
        return "redirect:/part2";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("task", service.getById(id));
        return "part2/details";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/part2";
    }
}
