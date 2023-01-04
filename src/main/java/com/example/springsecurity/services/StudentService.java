package com.example.springsecurity.services;


import com.example.springsecurity.dto.Student.StudentDto;
import com.example.springsecurity.dto.Student.UpdateStudent;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.models.User;
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

    public StudentDto getStudent(Long id){
        User user = userService.getUserById(id);
        Student student = studentRepository.findByUserID(id);
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentNo(student.getId());
        studentDto.setDepartment(student.getDepartment()); //student.getDep 'di Dto yapınca hata kalktı
        studentDto.setFaculty(student.getFaculty()); ////student.getFac 'di Dto yapınca hata kalktı
        studentDto.setLasName(user.getLastName());
        studentDto.setFirstName(user.getFirstName());

        return studentDto;
    }

    public StudentDto addStudent(StudentDto studentDto){
        Student student = new Student();
        studentDto.setStudentNo(studentDto.getStudentNo());
        studentDto.setFirstName(studentDto.getFirstName());
        studentDto.setLasName(studentDto.getLasName());
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
