package com.shuravi.librarymanagementsystemaccio.mapper;

import com.shuravi.librarymanagementsystemaccio.dto.LibraryCardDto;
import com.shuravi.librarymanagementsystemaccio.enums.CardStatus;
import com.shuravi.librarymanagementsystemaccio.model.LibraryCardEntity;
import com.shuravi.librarymanagementsystemaccio.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring",
        imports = {UUID.class, CardStatus.class})
public abstract class LibraryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "issueDate", ignore = true)
    @Mapping(target = "cardNo", expression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "cardStatus", expression = "java(CardStatus.ACTIVE)")
    @Mapping(target = "student", source = "studentEntity")
    public abstract LibraryCardEntity createLibraryCardEntity(StudentEntity studentEntity);
    
    public abstract LibraryCardDto mapToDto(LibraryCardEntity entity);
}
