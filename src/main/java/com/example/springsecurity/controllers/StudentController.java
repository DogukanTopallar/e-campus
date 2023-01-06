package com.example.springsecurity.controllers;


import com.example.springsecurity.dto.Student.StudentDto;
import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.repos.StudentRepository;
import com.example.springsecurity.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id)
    {
        return ResponseEntity.ok(studentService.getStudent(id));
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping("/student/{id}")
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudent()
    {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

//    @PostMapping("/student")
//    @ResponseBody
//    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto){
//        return new ResponseEntity(studentService.createStudent(studentDto), HttpStatus.CREATED);
//    }

//    @Secured("ROLE_ADMIN")
//    @PostMapping("/departments/{id}/student")
//    public ResponseEntity<StudentDto> addStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/student").toUriString());
//        StudentDto new_student = studentService.addStudent(studentDto);
//        System.out.println(new_student);
//        return ResponseEntity.created(uri).body(new_student);
//    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/departments/{id}/student")
    public ResponseEntity<StudentDto> addStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
        return new ResponseEntity(studentService.addStudent(id, studentDto), HttpStatus.CREATED);
    }
}
