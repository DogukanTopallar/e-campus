package com.example.springsecurity.models;

import com.example.springsecurity.repos.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Institute {
    @Id
    @GeneratedValue
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
