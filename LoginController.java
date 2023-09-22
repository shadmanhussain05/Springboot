package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.repository.TeacherRepository;
import com.school.entities.Student;
import com.school.entities.Teacher;
import com.school.repository.StudentRepository;

@RestController
public class LoginController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Student student = studentRepository.findByUsername(username);   
        Teacher teacher = teacherRepository.findByUsername(username);


        if (student != null && student.getPassword().equals(password)) {
            // Student login successful
            return "redirect:/student/dashboard";
        } else if (teacher != null && teacher.getPassword().equals(password)) {
            // Teacher login successful
            return "redirect:/teacher/dashboard";
        } else {
            // Invalid login, return to the login page with an error message
            return "redirect:/login?error";
        }
    }
}
