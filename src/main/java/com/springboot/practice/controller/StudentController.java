package com.springboot.practice.controller;


import com.springboot.practice.dto.StudentDto;
import com.springboot.practice.entity.Student;
import com.springboot.practice.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping("/student")
    public StudentDto getStudent(Integer sid){
        return new StudentDto(1,"Rahul",21);
    }

    @GetMapping("/student-all")
    public List<Student> getAllStudent(Integer sid){
        return studentRepository.findAll();
    }
}
