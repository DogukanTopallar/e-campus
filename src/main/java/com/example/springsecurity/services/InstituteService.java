package com.example.springsecurity.services;

import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.Institute;
import com.example.springsecurity.repos.InstituteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Institute updateInstitute(Long id, Institute institute) {
        Optional<Institute> instituteOptional = instituteRepository.findById(id);
        instituteOptional.ifPresent(instituteNew -> {
            instituteNew.setId(institute.getId());
            instituteNew.setName(institute.getName());
            instituteRepository.save(instituteNew);
        });
        return instituteOptional.orElse(new Institute());
    }

}
