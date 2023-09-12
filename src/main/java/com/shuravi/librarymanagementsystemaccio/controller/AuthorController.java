package com.shuravi.librarymanagementsystemaccio.controller;

import com.shuravi.librarymanagementsystemaccio.dto.input.AuthorInput;
import com.shuravi.librarymanagementsystemaccio.service.AuthorService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody AuthorInput input) {
        var response = authorService.addAuthor(input);
        if (response == null) {
            return new ResponseEntity("Unable to add Author", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
