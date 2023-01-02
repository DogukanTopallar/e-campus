package com.example.springsecurity.repos;

import com.example.springsecurity.models.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepository extends JpaRepository<Institute, Long> {
}
