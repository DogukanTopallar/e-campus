package com.example.springsecurity.models;

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
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    private String name;


    @JsonIgnore
    @ManyToOne
    private Faculty faculty;

    @JsonIgnore
    @ManyToOne
    private Institute institute;

    @OneToMany(mappedBy = "department")
    private List<Student> students= new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private Collection<Course> courses=new ArrayList<>();
}
