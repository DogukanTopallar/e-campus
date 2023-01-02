package com.example.springsecurity.services;

import com.example.springsecurity.models.Course;
import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.FacultyRepository;
import com.example.springsecurity.repos.InstituteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    public final DepartmentRepository departmentRepository;
    public final FacultyRepository facultyRepository;
    public final InstituteRepository instituteRepository;

    public Department addDepartment(Long id, Department department){
        department.setFaculty(facultyRepository.findById(id).orElse(null));
        return departmentRepository.save(department);
    }

    public Department getDepartment(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

    public List<Student> students(Long departmentId){
        return departmentRepository.findById(departmentId).orElse(null).getStudents();
    }

    public Collection<Course> allCourses(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null).getCourses();

    }

}
