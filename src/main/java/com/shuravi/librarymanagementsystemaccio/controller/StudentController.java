package com.shuravi.librarymanagementsystemaccio.controller;

import com.shuravi.librarymanagementsystemaccio.input.StudentInput;
import com.shuravi.librarymanagementsystemaccio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody StudentInput student) {
        var response = studentService.addStudent(student);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-by-roll")
    public ResponseEntity getStudentByRoll(@RequestParam("rollNo") int roll) {
        var response = studentService.getStudentByRoll(roll);
        if (response == null) {
            return new ResponseEntity("Invalid Roll Number", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-by-id")
    public ResponseEntity getStudent(@RequestParam("id") String id) {
        var response = studentService.getStudentById(id);
        if (response == null) {
            return new ResponseEntity("Invalid Roll Number", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }
}
