package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.User;
import com.example.springsecurity.repos.FacultyRepository;
import com.example.springsecurity.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;
    private final FacultyRepository facultyRepository;

    @GetMapping("/faculties")
    public ResponseEntity<List<Faculty>> getAllFaculty(){
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }

    @GetMapping("/faculties/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id){
        return ResponseEntity.ok(facultyService.getFacultyById(id));
    }

    @Secured({"ROLE_ADMIN","ROLE_FACULTY_MANAGEMENT"})
    @PostMapping("/faculty")
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty){
        return ResponseEntity.ok(facultyService.addFaculty(faculty));
    }
    @Secured({"ROLE_ADMIN","ROLE_FACULTY_MANAGEMENT"})
    @DeleteMapping("/faculties/{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @Secured({"ROLE_ADMIN","ROLE_FACULTY_MANAGEMENT"})
    @PutMapping("/faculties/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty){
        return ResponseEntity.ok(facultyService.updateFaculty(id,faculty));
    }


}
