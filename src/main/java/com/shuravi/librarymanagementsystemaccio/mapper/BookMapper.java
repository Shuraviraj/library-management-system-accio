package com.shuravi.librarymanagementsystemaccio.mapper;

import com.shuravi.librarymanagementsystemaccio.dto.BookDto;
import com.shuravi.librarymanagementsystemaccio.input.BookInput;
import com.shuravi.librarymanagementsystemaccio.model.AuthorEntity;
import com.shuravi.librarymanagementsystemaccio.model.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = AuthorMapper.class)
public abstract class BookMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", source = "authorEntity")
    public abstract BookEntity mapToEntity(BookInput input, AuthorEntity authorEntity);


    @Mapping(target = "author", source = "author")
    @Mapping(target = "author.books", ignore = true)
    public abstract BookDto mapToDto(BookEntity savedBook);
}
