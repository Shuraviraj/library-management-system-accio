package com.shuravi.librarymanagementsystemaccio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired StudentService studentService;

  @PostMapping("/add")
  public ResponseEntity addStudent(@RequestBody StudentDto student) {
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

  @GetMapping("/get-by-id")
  public ResponseEntity getStudent(@RequestParam("id") String id) {
    StudentDto response = studentService.getStudentById(id);
    if (response == null) {
      return new ResponseEntity("Invalid Roll Number", HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity(response, HttpStatus.FOUND);
  }
}
