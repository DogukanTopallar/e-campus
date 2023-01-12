package com.example.springsecurity.repos;

import com.example.springsecurity.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public Student findByUserID(Long id);
    public void deleteById(Long id);
}
