package com.example.springsecurity.controllers;

import com.example.springsecurity.services.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationEntryPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonalController {
    private final PersonalService personalService;

    @GetMapping("/personal/id")
    public ResponseEntity<?> getPersonal(@RequestParam Long id)
    {
        return ResponseEntity.ok(personalService.getPersonal(id));
    }

}
