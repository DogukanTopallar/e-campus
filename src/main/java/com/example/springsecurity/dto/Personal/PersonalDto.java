package com.example.springsecurity.dto.Personal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalDto {
    private Long personalNo;
    private String firstName;
    private String lastName;
    private String department;
    private String faculty;
    private String institute;
    private String title;
}
