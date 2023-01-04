package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Course;
import com.example.springsecurity.models.Department;
import com.example.springsecurity.repos.CourseRepository;
import com.example.springsecurity.services.CourseService;
import com.example.springsecurity.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final DepartmentService departmentService;
    private final CourseRepository courseRepository;

    @PostMapping("/departments/{id}/course")
    @ResponseBody
    public ResponseEntity<Course> addCourse(@PathVariable Long id, @RequestBody Course course){
        return new ResponseEntity(courseService.addCourse(id, course), HttpStatus.CREATED);
    }

//    @PostMapping("/faculties/{facultyId}/departments/{departmentId}/course")
//    @ResponseBody
//    public ResponseEntity<Course> addCourseOnFacultyDepartment(@PathVariable Long facultyId,@PathVariable Long departmentId,  @RequestBody Course course){
//        return new ResponseEntity(courseService.addCourse(facultyId, departmentId, course), HttpStatus.CREATED);
//    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourse()
    {
        return ResponseEntity.ok(courseService.getAllCourse());
    }
}
