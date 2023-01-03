package com.example.springsecurity.controllers;


import com.example.springsecurity.dto.Student.StudentDto;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudents(@RequestParam Long id)
    {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @PostMapping("/student")
    @ResponseBody
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity(studentService.createStudent(studentDto), HttpStatus.CREATED);
    }
}
