package com.shuravi.librarymanagementsystemaccio.controller;

import com.shuravi.librarymanagementsystemaccio.exception.AuthorNotFoundException;
import com.shuravi.librarymanagementsystemaccio.input.BookInput;
import com.shuravi.librarymanagementsystemaccio.service.BookService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
@RequestMapping("/book")
public class Bookcontroller {

    @Autowired
    BookService service;

    @PostMapping("/add/{author-id}")
    public ResponseEntity addBook(@PathVariable("author-id") Long authorId, @RequestBody BookInput input) {
        try {
            var response = service.addBook(input, authorId);
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (AuthorNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
