package com.example.springsecurity.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Long studentNo;
    private String lasName;
    private String firstName;
    private String department;
    private String faculty;
}
