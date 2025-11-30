package com.springboot.practice.service.impl;

import com.springboot.practice.dto.AddStudentDto;
import com.springboot.practice.dto.StudentDto;
import com.springboot.practice.entity.Student;
import com.springboot.practice.repository.StudentRepository;
import com.springboot.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    public final StudentRepository studentRepository;
    public final ModelMapper modelMapper;
    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(student -> new StudentDto(student.getSid(),student.getSname(),student.getAge())).toList();
    }

    @Override
    public StudentDto getStudentById(int id) {
        Student student= studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with Id"));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto addNewStudent(AddStudentDto addStudentDto) {
        Student student=modelMapper.map(addStudentDto, Student.class);
        return modelMapper.map(studentRepository.save(student), StudentDto.class);
    }

    @Override
    public ResponseEntity<Void> deleteStudentById(int id) {
        try{
            if(studentRepository.existsById(id)) {
                studentRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            }else{
                throw new IllegalArgumentException("Student not found with Id: "+id);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public StudentDto updateStudentById(StudentDto studentDto) {
        if(studentRepository.existsById(studentDto.getSid())) {
            Student student=modelMapper.map(studentDto, Student.class);
            return modelMapper.map(studentRepository.save(student), StudentDto.class);
        }else{
            throw new IllegalArgumentException("Student not found with Id: "+studentDto.getSid());
        }
    }
}
