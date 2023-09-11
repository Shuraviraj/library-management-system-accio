package com.shuravi.librarymanagementsystemaccio.service;

import com.shuravi.librarymanagementsystemaccio.dto.StudentDto;
import com.shuravi.librarymanagementsystemaccio.input.StudentInput;
import com.shuravi.librarymanagementsystemaccio.mapper.StudentMapper;
import com.shuravi.librarymanagementsystemaccio.model.StudentEntity;
import com.shuravi.librarymanagementsystemaccio.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;

    public StudentDto addStudent(StudentInput student) {
        var studentEntity = studentMapper.addUuid(student);
        var savedStudent = studentRepository.save(studentEntity);
        return studentMapper.mapToStudentDto(savedStudent);
    }

    public List<StudentDto> getStudentByRoll(int roll) {
        var studentEntities = studentRepository.findByrollNumber(roll);
        return studentEntities.stream().map(s -> studentMapper.mapToStudentDto(s)).toList();
    }

    public StudentDto getStudentById(String id) {
        var student = studentRepository.findById(UUID.fromString(id));
        return student.map(studentEntity -> studentMapper.mapToStudentDto(studentEntity)).orElse(null);
    }

    public List<StudentEntity> getStudentEntityByRoll(int roll) {
        return studentRepository.findByrollNumber(roll);
    }
}
