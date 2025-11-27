package com.springboot.practice.controller;


import com.springboot.practice.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent(Integer sid){
        return new StudentDto(1,"Rahul",21);
    }
}
