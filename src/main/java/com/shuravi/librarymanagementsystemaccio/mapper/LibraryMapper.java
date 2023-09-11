package com.shuravi.librarymanagementsystemaccio.mapper;

import com.shuravi.librarymanagementsystemaccio.enums.CardStatus;
import com.shuravi.librarymanagementsystemaccio.model.LibraryCardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring",
        imports = {UUID.class})
public abstract class LibraryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "issueDate", ignore = true)
    @Mapping(target = "cardNo", expression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "cardStatus", source = "cardStatus")
    public abstract LibraryCardEntity createLibraryCardEntity(CardStatus cardStatus);
}
