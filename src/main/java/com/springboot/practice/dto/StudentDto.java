package com.springboot.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private int sid;
    private String sname;
    private int age;
}
