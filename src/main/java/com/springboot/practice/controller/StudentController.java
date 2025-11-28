package com.springboot.practice.controller;


import com.springboot.practice.dto.StudentDto;
import com.springboot.practice.entity.Student;
import com.springboot.practice.repository.StudentRepository;
import com.springboot.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/student")
    public StudentDto getStudent(Integer sid){
        return new StudentDto(1,"Rahul",21);
    }

    @GetMapping("/student-all")
    public List<StudentDto> getAllStudent(Integer sid){
        return studentService.getAllStudents();
    }
}
