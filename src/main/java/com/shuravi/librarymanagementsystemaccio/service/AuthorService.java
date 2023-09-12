package com.shuravi.librarymanagementsystemaccio.service;

import com.shuravi.librarymanagementsystemaccio.dto.AuthorDto;
import com.shuravi.librarymanagementsystemaccio.input.AuthorInput;
import com.shuravi.librarymanagementsystemaccio.mapper.AuthorMapper;
import com.shuravi.librarymanagementsystemaccio.repository.AuthorRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorService {
    @Autowired
    AuthorRepository repository;
    @Autowired
    AuthorMapper mapper;

    public AuthorDto addAuthor(AuthorInput input) {
        var authorEntity = mapper.mapToEntity(input);
        var savedAuthor = repository.save(authorEntity);
        return mapper.mapToDto(savedAuthor);
    }
}
