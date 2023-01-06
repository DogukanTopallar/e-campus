package com.example.springsecurity.controllers;

import com.example.springsecurity.models.User;
import com.example.springsecurity.models.UserRole;
import com.example.springsecurity.repos.UserRoleRepository;
import com.example.springsecurity.services.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRoleController {
    private final UserRoleService userRoleService;
    @Secured("ROLE_ADMIN")
    @PostMapping("/roles")
    public ResponseEntity<UserRole> saveRole(@RequestBody UserRole userRole) {
        return ResponseEntity.ok(userRoleService.saveRole(userRole));
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/roles").toUriString());
//        return ResponseEntity.created(uri).body(userRoleService.saveRole(userRole));
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/roles")
    public ResponseEntity<List<UserRole>> getRoles()
    {
        return ResponseEntity.ok(userRoleService.getAll());
    }
}
