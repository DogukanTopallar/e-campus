package com.example.springsecurity.dto.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private Long studentNo;
    private String lasName;
    private String firstName;
    private String department;
    private String faculty;
}

