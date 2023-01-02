package com.example.springsecurity.services;

import com.example.springsecurity.models.Institute;
import com.example.springsecurity.repos.InstituteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstituteService {
    private final InstituteRepository instituteRepository;

    public Institute getInstitute(Long id){
        return instituteRepository.findById(id).get();
    }

    public Institute addInstitute(Institute institute){
        return instituteRepository.save(institute);
    }

    public void deleteInstitute(Long id){
         instituteRepository.deleteById(id);
    }

    public List<Institute> gelAllInstitute(){
        return instituteRepository.findAll();
    }

}
