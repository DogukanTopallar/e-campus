package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.User;
import com.example.springsecurity.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping("/faculties")
    public ResponseEntity<List<Faculty>> getAllFaculty(){
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }

    @GetMapping("/faculties/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id){
        return ResponseEntity.ok(facultyService.getFaculty(id));
    }

//    @PostMapping("/faculty")
//    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty){
//        return ResponseEntity.ok(facultyService.addFaculty(faculty));
//    }

    @PostMapping("/faculties")
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users").toUriString());
        Faculty new_faculty = facultyService.addFaculty(faculty);
        System.out.println(new_faculty);
        return ResponseEntity.created(uri).body(new_faculty);
    }
}
