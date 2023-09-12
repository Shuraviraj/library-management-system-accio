package com.shuravi.librarymanagementsystemaccio.service;

import com.shuravi.librarymanagementsystemaccio.dto.BookDto;
import com.shuravi.librarymanagementsystemaccio.exception.AuthorNotFoundException;
import com.shuravi.librarymanagementsystemaccio.input.BookInput;
import com.shuravi.librarymanagementsystemaccio.mapper.BookMapper;
import com.shuravi.librarymanagementsystemaccio.repository.AuthorRepository;
import com.shuravi.librarymanagementsystemaccio.repository.BookRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookMapper mapper;

    public BookDto addBook(BookInput input, Long authorId) {
        var authorEntityOptional = authorRepository.findById(authorId);
        if (authorEntityOptional.isEmpty()) {
            throw new AuthorNotFoundException("Invalid Author Id");
        }

        var authorEntity = authorEntityOptional.get();
        var bookEntity = mapper.mapToEntity(input, authorEntity);

        authorEntity.getBooks().add(bookEntity);

        var savedBook = bookRepository.save(bookEntity);
        authorRepository.save(authorEntity);

        return mapper.mapToDto(savedBook);
    }
}
