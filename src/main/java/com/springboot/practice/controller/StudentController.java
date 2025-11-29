package com.springboot.practice.controller;


import com.springboot.practice.dto.AddStudentDto;
import com.springboot.practice.dto.StudentDto;
import com.springboot.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/student/{sid}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer sid){
        return ResponseEntity.ok(studentService.getStudentById(sid));
    }

    @PostMapping("/create/student")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentDto studentDto){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.addNewStudent(studentDto));
    }
    @GetMapping("/student-all")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @DeleteMapping("/student/delete")
    public ResponseEntity<String> deleteStudentById(@RequestParam Integer sid){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStudentById(sid));
    }
}
