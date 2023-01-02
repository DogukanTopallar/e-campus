package com.example.springsecurity.services;

import com.example.springsecurity.models.Course;
import com.example.springsecurity.repos.CourseRepository;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.FacultyRepository;
import com.example.springsecurity.repos.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;

    public Course getCourse(Long id){
        return  courseRepository.findById(id).get();
    }

    public Course addCourse(Long id, Course course){
        course.setDepartment(departmentRepository.findById(id).orElse(null));
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
    

}
