package com.example.springsecurity.dto.Personal;

import lombok.Data;

@Data
public class PersonalDto {
    private Long personalNo;
    private String firstName;
    private String lastName;
    private String department;
    private String faculty;
    private String institute;
    private String title;
}
