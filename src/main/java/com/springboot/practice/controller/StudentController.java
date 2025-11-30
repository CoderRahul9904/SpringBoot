package com.springboot.practice.controller;


import com.springboot.practice.dto.AddStudentDto;
import com.springboot.practice.dto.StudentDto;
import com.springboot.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Void> deleteStudentById(@RequestParam Integer sid){
        return studentService.deleteStudentById(sid);
    }

    @PatchMapping("/update/student")
    public ResponseEntity<StudentDto> updateStudentById(@RequestBody StudentDto studentDto){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudentById(studentDto));
    }

//    @PutMapping("/change/student")
//    public ResponseEntity<StudentDto> changeStudentById(@RequestBody StudentDto studentDto){
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudentById(studentDto));
//    }
}
