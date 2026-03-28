package com.controller;

import com.model.Student;
import com.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }

    // Show add form
    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }
    // Save new student
    @PostMapping
    public String createStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult result,
                                Model model) {

        if (result.hasErrors()) {
            model.addAttribute("student", student); // 👈 IMPORTANT
            return "form";
        }

        service.createStudent(student);
        return "redirect:/students/list";
    }

    // Show all students
    @GetMapping("/list")
    public String displayAllStudents(Model model) {
        model.addAttribute("students", service.displayAllStudents());
        return "students";
    }

    // Show update form
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.displayById(id));
        return "update";
    }

    // Handle update form submission
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        service.updateStudent(id, student);
        return "redirect:/students/list";
    }

    // Delete single student
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/students/list";
    }

    // Delete all students
    @PostMapping("/delete/all")
    public String deleteAllStudents() {
        service.deleteAllStudents();
        return "redirect:/students/list";
    }
}