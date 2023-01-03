package com.example.springsecurity.models;

import com.example.springsecurity.repos.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany
    private Collection<Student> students;

    @OneToMany
    private Collection<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "institute")
    private List<Department> departmentList = new ArrayList<>();
}
