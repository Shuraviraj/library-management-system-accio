package com.shuravi.librarymanagementsystemaccio.service;

import com.shuravi.librarymanagementsystemaccio.dto.StudentDto;
import com.shuravi.librarymanagementsystemaccio.dto.input.StudentInput;
import com.shuravi.librarymanagementsystemaccio.enums.Gender;
import com.shuravi.librarymanagementsystemaccio.mapper.StudentMapper;
import com.shuravi.librarymanagementsystemaccio.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    LibraryCardService libraryCardService;

    @Transactional
    public StudentDto addStudent(StudentInput student) {
        var studentEntity = studentMapper.createStudentEntity(student);
        var libraryCard = libraryCardService.createLibraryCard(studentEntity);
        studentEntity.setLibraryCard(libraryCard);
        var savedStudent = studentRepository.save(studentEntity);
        return studentMapper.mapToStudentDto(savedStudent);
    }

    public List<StudentDto> getStudentByRoll(int roll) {
        var studentEntities = studentRepository.findByRollNumber(roll);
        return studentEntities.stream().map(s -> studentMapper.mapToStudentDto(s)).toList();
    }

    public StudentDto getStudentById(String id) {
        var student = studentRepository.findById(id);
        return student.map(studentEntity -> studentMapper.mapToStudentDto(studentEntity)).orElse(null);
    }

    public StudentDto deleteStudentById(String id) {
        var studentEntity = studentRepository.findById(id);
        if (studentEntity.isPresent()) {
            studentRepository.deleteById(id);
            return studentMapper.mapToStudentDto(studentEntity.get());
        }
        return null;
    }

    public StudentDto updateAgeStudentById(String id, Integer newAge) {
        var studentEntity = studentRepository.findById(id);
        if (studentEntity.isPresent()) {
            var updatedStudentEntity = studentMapper.mapNewAge(studentEntity.get(), newAge);
            return studentMapper.mapToStudentDto(studentRepository.save(updatedStudentEntity));
        }

        return null;
    }

    public List<StudentDto> getStudents() {
        var students = studentRepository.findAll();
        return students.stream().map(studentMapper::mapToStudentDto).toList();
    }

    public List<StudentDto> getMaleStudents() {
        var students = studentRepository.findByGender(Gender.MALE);
        return students.stream().map(studentMapper::mapToStudentDto).toList();
    }
}
