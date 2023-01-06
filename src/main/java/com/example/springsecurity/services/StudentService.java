package com.example.springsecurity.services;


import com.example.springsecurity.dto.Student.StudentDto;
import com.example.springsecurity.dto.Student.UpdateStudent;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.models.User;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    public final StudentRepository studentRepository;
    public final UserService userService;
    private final DepartmentRepository departmentRepository;

    public StudentDto getStudent(Long id){
        User user = userService.getUserById(id);
        Student student = studentRepository.findByUserID(id);
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentNo(student.getId());
        studentDto.setDepartment(student.getDepartment()); //student.getDep 'di Dto yapınca hata kalktı
        studentDto.setLastName(user.getLastName());
        studentDto.setFirstName(user.getFirstName());

        return studentDto;
    }

    public StudentDto addStudent(Long id,StudentDto studentDto){
        studentDto.setDepartment(departmentRepository.findById(id).orElse(null));
        Student student = new Student();
        studentDto.setStudentNo(studentDto.getStudentNo());
        studentDto.setFirstName(studentDto.getFirstName());
        studentDto.setLastName(studentDto.getLastName());
        studentDto.setDepartment(studentDto.getDepartment());

        studentRepository.save(student);

        return studentDto;
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

//    public StudentDto updateStudent(long id, UpdateStudent updateStudent){
//        Optional<StudentDto> studentDtoOptional = studentRepository.findByUserID(id);
//        studentDtoOptional.ifPresent(studentDto -> {
//            studentDto.setFirstName(updateStudent.getFirstName());
//            studentDto.setLasName(updateStudent.getLasName());
//            studentDto.setDepartment(updateStudent.getDepartment());
//            studentDto.setFaculty(updateStudent.getFaculty());
//            studentDto.setStudentNo(updateStudent.getStudentNo());
//        });
//        return new StudentDto();
//    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
