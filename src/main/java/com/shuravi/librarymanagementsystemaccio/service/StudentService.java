package com.shuravi.librarymanagementsystemaccio.service;

import com.shuravi.librarymanagementsystemaccio.mapper.StudentMapper;
import com.shuravi.librarymanagementsystemaccio.model.StudentDto;
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

    public StudentDto addStudent(StudentDto student) {
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
        if (student.isPresent()) {
            return studentMapper.mapToStudentDto(student.get());
        }
        return null;
    }
}
