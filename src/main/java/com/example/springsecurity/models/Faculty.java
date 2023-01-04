package com.example.springsecurity.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "faculty")
    private Collection<Student> students;

    @OneToMany
    private Collection<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "faculty")
    private List<Department> departmentList = new ArrayList<>();
}
