package com.shuravi.librarymanagementsystemaccio.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException() {
        super();
    }

    public AuthorNotFoundException(String message) {
        super(message);
    }
}
