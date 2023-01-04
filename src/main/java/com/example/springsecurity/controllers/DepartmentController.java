package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Department;

import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartment(id));
    }

    @GetMapping("/departments")
    public ResponseEntity<?> getAllDepartment()
    {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }


    @PostMapping("/faculties/{id}/department")
    @ResponseBody
    public ResponseEntity<Department> addDepartment(@PathVariable Long id, @RequestBody Department department){
        return new ResponseEntity(departmentService.addDepartment(id, department), HttpStatus.CREATED);
    }

    @PostMapping("/institutes/{id}/department")
    @ResponseBody
    public ResponseEntity<Department> addDepartmentUsingByInstitute(@PathVariable Long id, @RequestBody Department department){
        return new ResponseEntity(departmentService.addDepartmentUsingByInstitute(id, department), HttpStatus.CREATED);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }
}
