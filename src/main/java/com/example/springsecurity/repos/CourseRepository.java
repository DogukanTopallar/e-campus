package com.example.springsecurity.repos;

import com.example.springsecurity.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
