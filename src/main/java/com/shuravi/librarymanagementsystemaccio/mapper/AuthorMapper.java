package com.shuravi.librarymanagementsystemaccio.mapper;

import com.shuravi.librarymanagementsystemaccio.dto.AuthorDto;
import com.shuravi.librarymanagementsystemaccio.input.AuthorInput;
import com.shuravi.librarymanagementsystemaccio.model.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = BookMapper.class)
public abstract class AuthorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lastActivity", ignore = true)
    public abstract AuthorEntity mapToEntity(AuthorInput input);

    public abstract AuthorDto mapToDto(AuthorEntity savedAuthor);
}
