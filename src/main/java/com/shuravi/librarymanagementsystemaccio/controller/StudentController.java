package com.shuravi.librarymanagementsystemaccio.controller;

import com.shuravi.librarymanagementsystemaccio.dto.StudentDto;
import com.shuravi.librarymanagementsystemaccio.input.StudentInput;
import com.shuravi.librarymanagementsystemaccio.model.StudentEntity;
import com.shuravi.librarymanagementsystemaccio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody StudentInput student) {
        StudentDto response = studentService.addStudent(student);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-by-roll")
    public ResponseEntity getStudentByRoll(@RequestParam("rollNo") int roll) {
        List<StudentDto> response = studentService.getStudentByRoll(roll);
        if (response == null) {
            return new ResponseEntity("Invalid Roll Number", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-student-entity-by-roll")
    public ResponseEntity getStudentEntityByRoll(@RequestParam("rollNo") int roll) {
        List<StudentEntity> response = studentService.getStudentEntityByRoll(roll);
        if (response == null) {
            return new ResponseEntity("Invalid Roll Number", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-by-id")
    public ResponseEntity getStudent(@RequestParam("id") String id) {
        StudentDto response = studentService.getStudentById(id);
        if (response == null) {
            return new ResponseEntity("Invalid Roll Number", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }
}
