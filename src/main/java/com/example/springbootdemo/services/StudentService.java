package com.example.springbootdemo.services;

import com.example.springbootdemo.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();
    private long idCounter = 1L;

    public List<Student> getAllStudents() {
        return students;
    }

    public void addStudent(String name, String surname, int exam) {
        students.add(new Student(idCounter++, name, surname, exam));
    }
}