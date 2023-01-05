package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Institute;
import com.example.springsecurity.services.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstituteController {
    private final InstituteService instituteService;

    @GetMapping("/institutes")
    public ResponseEntity<List<Institute>> getAllInstitute(){
        return ResponseEntity.ok(instituteService.gelAllInstitute());
    }
    @GetMapping("/institutes/{id}")
    public ResponseEntity<Institute> getInstituteById(@PathVariable Long id){
        return ResponseEntity.ok(instituteService.getInstitute(id));
    }
    @Secured({"ROLE_ADMIN","ROLE_INSTITUTE_MANAGEMENT"})
    @PostMapping("/institute")
    public ResponseEntity<Institute> addInstitute(@RequestBody Institute institute){
        return ResponseEntity.ok(instituteService.addInstitute(institute));
    }
    @Secured({"ROLE_ADMIN","ROLE_INSTITUTE_MANAGEMENT"})
    @DeleteMapping("/institutes/{id}")
    public ResponseEntity<Institute> deleteInstitute(@PathVariable Long id){
        instituteService.deleteInstitute(id);
        return ResponseEntity.ok().build();
    }
    @Secured({"ROLE_ADMIN","ROLE_INSTITUTE_MANAGEMENT"})
    @PutMapping("/institutes/{id}")
    public ResponseEntity<Institute> updateInstitute(@PathVariable Long id, @RequestBody Institute institute){
        return ResponseEntity.ok(instituteService.updateInstitute(id, institute));
    }
}
