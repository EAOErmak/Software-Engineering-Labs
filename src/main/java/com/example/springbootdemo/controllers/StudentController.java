package com.example.springbootdemo.controllers;

import com.example.springbootdemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/part1")
    public String home(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "part1/students";
    }

    @GetMapping("/part1/add")
    public String addForm() {
        return "part1/add";
    }

    @PostMapping("/part1/add")
    public String addStudent(@RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam int exam) {
        service.addStudent(name, surname, exam);
        return "redirect:/part1";
    }
}