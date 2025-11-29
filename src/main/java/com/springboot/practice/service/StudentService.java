package com.springboot.practice.service;

import com.springboot.practice.dto.AddStudentDto;
import com.springboot.practice.dto.StudentDto;
import com.springboot.practice.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(int id);
    StudentDto addNewStudent(AddStudentDto addStudentDto);
    String deleteStudentById(int id);
}
