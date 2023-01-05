package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Department;

import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.FacultyRepository;
import com.example.springsecurity.services.DepartmentService;
import com.example.springsecurity.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final FacultyService facultyService;
    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartment()
    {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @Secured({"ROLE_ADMIN", "ROLE_FACULTY_MANAGEMENT"})
    @PostMapping("/faculties/{id}/department")
    @ResponseBody
    public ResponseEntity<Department> addDepartment(@PathVariable Long id, @RequestBody Department department){
        return new ResponseEntity(departmentService.addDepartment(id, department), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_INSTITUTE_MANAGEMENT"})
    @PostMapping("/institutes/{id}/department")
    @ResponseBody
    public ResponseEntity<Department> addDepartmentUsingByInstitute(@PathVariable Long id, @RequestBody Department department){
        return new ResponseEntity(departmentService.addDepartmentUsingByInstitute(id, department), HttpStatus.CREATED);
    }
    @Secured({"ROLE_ADMIN", "ROLE_INSTITUTE_MANAGEMENT", "ROLE_FACULTY_MANAGEMENT"})
    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }
}