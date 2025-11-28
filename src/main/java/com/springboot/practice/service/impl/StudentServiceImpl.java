package com.springboot.practice.service.impl;

import com.springboot.practice.dto.StudentDto;
import com.springboot.practice.entity.Student;
import com.springboot.practice.repository.StudentRepository;
import com.springboot.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    public final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(student -> new StudentDto(student.getSid(),student.getSname(),student.getAge())).toList();
    }
}
