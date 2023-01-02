package com.example.springsecurity.services;


import com.example.springsecurity.dto.StudentDto;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.models.User;
import com.example.springsecurity.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    public final StudentRepository studentRepository;
    public final UserService userService;

    public StudentDto getStudent(Long id){
        User user = userService.getUserById(id);
        Student student = studentRepository.findByUserID(id);
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentNo(student.getId());
        studentDto.setDepartment(student.getDepartment());
        studentDto.setFaculty(student.getFaculty());
        studentDto.setLasName(user.getLastName());
        studentDto.setFirstName(user.getFirstName());

        return studentDto;
    }

    public StudentDto createStudent(StudentDto studentDto){
        Student student = new Student();
        studentDto.setStudentNo(studentDto.getStudentNo());
        studentDto.setFirstName(studentDto.getFirstName());
        studentDto.setLasName(studentDto.getLasName());
        studentDto.setDepartment(studentDto.getDepartment());
        studentDto.setDepartment(studentDto.getDepartment());

        return studentDto;
    }

//    public StudentDto updateStudent(StudentDto studentDto){
//
//    }
}
