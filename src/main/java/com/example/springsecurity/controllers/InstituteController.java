package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.Institute;
import com.example.springsecurity.services.FacultyService;
import com.example.springsecurity.services.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("/institute")
    public ResponseEntity<Institute> addInstitute(@RequestBody Institute institute){
        return ResponseEntity.ok(instituteService.addInstitute(institute));
    }

    @DeleteMapping("/institutes/{id}")
    public ResponseEntity<Institute> deleteInstitute(@PathVariable Long id){
        instituteService.deleteInstitute(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/institutes/{id}")
    public ResponseEntity<Institute> updateInstitute(@PathVariable Long id, @RequestBody Institute institute){
        return ResponseEntity.ok(instituteService.updateInstitute(id, institute));
    }
}
