package com.example.springsecurity.services;

import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.FacultyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class FacultyService {
    private final DepartmentRepository departmentRepository;

    private final FacultyRepository facultyRepository;

    public Faculty getFacultyById(Long id){
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty addFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id){
        facultyRepository.deleteById(id);
    }

    public List<Faculty> getAllFaculty(){
        return facultyRepository.findAll();
    }

    public Collection<Department> departments(Long facultyId){
        return facultyRepository.findById(facultyId).orElse(null).getDepartmentList();
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        Optional<Faculty> facultyOptional = facultyRepository.findById(id);
        facultyOptional.ifPresent(facultyNew -> {
            facultyNew.setId(faculty.getId());
            facultyNew.setName(faculty.getName());
            facultyRepository.save(facultyNew);
        });
        return facultyOptional.orElse(new Faculty());


    }


}
