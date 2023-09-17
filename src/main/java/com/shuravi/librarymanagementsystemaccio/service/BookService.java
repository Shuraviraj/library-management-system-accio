package com.shuravi.librarymanagementsystemaccio.service;

import com.shuravi.librarymanagementsystemaccio.dto.BookDto;
import com.shuravi.librarymanagementsystemaccio.dto.input.BookInput;
import com.shuravi.librarymanagementsystemaccio.enums.Genre;
import com.shuravi.librarymanagementsystemaccio.exception.AuthorNotFoundException;
import com.shuravi.librarymanagementsystemaccio.mapper.BookMapper;
import com.shuravi.librarymanagementsystemaccio.repository.AuthorRepository;
import com.shuravi.librarymanagementsystemaccio.repository.BookRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookMapper mapper;

    public BookDto addBook(BookInput input) {
        var authorEntityOptional = authorRepository.findById(input.getAuthorId());
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

    public List<BookDto> getBookByGenreAndCostGreaterThan(Genre genre, Double cost) {
        var books = bookRepository.findByGenreAndCostGreaterThanHql(genre, cost);
        return books.stream().map(i -> mapper.mapToDto(i)).toList();
    }
}
