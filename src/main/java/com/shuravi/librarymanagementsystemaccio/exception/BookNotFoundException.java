package com.shuravi.librarymanagementsystemaccio.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String meString) {
        super(meString);
    }
}
