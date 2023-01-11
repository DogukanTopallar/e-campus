package com.example.springsecurity.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id")
    private Long userID;


    //birçok öğrenci bir deparment'a bağlı olabilir
    @JsonIgnore
    @ManyToOne
    private Department department;

    //birçok öğrenci tek bir fakülteye kayıtlı olabilir.
    @JsonIgnore
    @ManyToOne()
    private Faculty faculty;

}
