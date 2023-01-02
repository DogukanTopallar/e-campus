package com.example.springsecurity.controllers;


import com.example.springsecurity.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/student/id")
    public ResponseEntity<?> getStudents(@RequestParam Long id)
    {
        return ResponseEntity.ok(studentService.getStudent(id));
    }
}
