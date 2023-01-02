package com.example.springsecurity.repos;


import com.example.springsecurity.models.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long> {
    public Personal findByUserID(Long id);
}
