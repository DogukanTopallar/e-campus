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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToOne
    private Faculty faculty;

    @JsonIgnore
    @ManyToOne
    private Institute institute;

    @JsonIgnore //postman isteklerinde sürekli alt alta eklediği için sunumdan sonra eklendi
    @OneToMany(mappedBy = "department")
    private List<Student> students= new ArrayList<>();

    @JsonIgnore //postman isteklerinde sürekli alt alta eklediği için sunumdan sonra eklendi
    @OneToMany(mappedBy = "department")
    private Collection<Course> courses=new ArrayList<>();
}
