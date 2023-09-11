package com.shuravi.librarymanagementsystemaccio.controller;

import com.shuravi.librarymanagementsystemaccio.input.StudentInput;
import com.shuravi.librarymanagementsystemaccio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity deleteStudentById(@PathVariable("id") String id) {
        var response = studentService.deleteStudentById(id);
        if (response == null) {
            return new ResponseEntity("Invalid Roll Number", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/update-age-by-id/{id}")
    public ResponseEntity updateAgeStudentById(@PathVariable("id") String id, @RequestParam Integer newAge) {
        var response = studentService.updateAgeStudentById(id, newAge);
        if (response == null) {
            return new ResponseEntity("Invalid Roll Number", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    @GetMapping("/get")
    public ResponseEntity getStudents() {
        var response = studentService.getStudents();
        if (response == null) {
            return new ResponseEntity("Invalid Roll Number", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-male-student")
    public ResponseEntity getMaleStudents() {
        var response = studentService.getMaleStudents();
        if (response == null) {
            return new ResponseEntity("Invalid Roll Number", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }
}
