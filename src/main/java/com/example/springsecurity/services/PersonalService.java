package com.example.springsecurity.services;


import com.example.springsecurity.dto.Personal.PersonalDto;
import com.example.springsecurity.dto.Student.StudentDto;
import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Personal;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.models.User;
import com.example.springsecurity.repos.PersonalRepository;
import com.example.springsecurity.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalService {

    public final StudentRepository studentRepository;
    public final UserService userService;
    private final PersonalRepository personalRepository;

    public PersonalDto getPersonal(Long id){
        User user = userService.getUserById(id);
        Personal personal = personalRepository.findByUserID(id);
        PersonalDto personalDto = new PersonalDto();

        personalDto.setPersonalNo(personal.getId());
        personalDto.setDepartment(personal.getDepartment());
        personalDto.setFaculty(personal.getFaculty());
        personalDto.setInstitute(personal.getInstitute());
        personalDto.setTitle(personal.getTitle());
        personalDto.setFirstName(user.getFirstName());
        personalDto.setLastName(user.getLastName());

        return personalDto;
    }
    public PersonalDto addPersonal(PersonalDto personalDto){
        Personal personal = new Personal();
        personalDto.setPersonalNo(personalDto.getPersonalNo());
        personalDto.setFirstName(personalDto.getFirstName());
        personalDto.setLastName(personalDto.getLastName());
        personalDto.setDepartment(personalDto.getDepartment());
        personalDto.setDepartment(personalDto.getDepartment());

        personalRepository.save(personal);

        return personalDto;
    }

    public void deletePersonal(Long id){personalRepository.deleteById(id);}

    public List<Personal> getAllPersonal(){
        return personalRepository.findAll();
    }


}


    //update yazmadım.