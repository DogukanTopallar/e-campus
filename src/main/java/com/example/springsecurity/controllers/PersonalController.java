package com.example.springsecurity.controllers;

import com.example.springsecurity.dto.Personal.PersonalDto;
import com.example.springsecurity.dto.Student.StudentDto;
import com.example.springsecurity.services.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationEntryPoint;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class PersonalController {
    private final PersonalService personalService;

    @GetMapping("/personal/id")
    public ResponseEntity<?> getPersonal(@RequestParam Long id)
    {
        return ResponseEntity.ok(personalService.getPersonal(id));
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/personal")
    public ResponseEntity<PersonalDto> addPersonal(@RequestBody PersonalDto personalDto){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/personal").toUriString());
        PersonalDto new_personal = personalService.addPersonal(personalDto);
        System.out.println(new_personal);
        return ResponseEntity.created(uri).body(new_personal);
    }

}
