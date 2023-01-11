package com.example.springsecurity.dto;

import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Faculty;
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
    private String firstName;
    private String lastName;


    //Dto dan department varlığı kaldırıldı
    //private Department department;

    // student modelde bulunan entityler:
    // id
    // userID
    // department
    // faculty
}

