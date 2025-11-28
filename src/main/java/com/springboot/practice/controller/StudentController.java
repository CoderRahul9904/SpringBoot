package com.springboot.practice.controller;


import com.springboot.practice.dto.StudentDto;
import com.springboot.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/student/{sid}")
    public StudentDto getStudentById(@PathVariable Integer sid){
        return studentService.getStudentById(sid);
    }

    @GetMapping("/student-all")
    public List<StudentDto> getAllStudent(){
        return studentService.getAllStudents();
    }
}
