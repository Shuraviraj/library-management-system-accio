package com.shuravi.librarymanagementsystemaccio.mapper;

import com.shuravi.librarymanagementsystemaccio.model.StudentDto;
import com.shuravi.librarymanagementsystemaccio.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(
        componentModel = "spring",
        imports = {UUID.class})
public abstract class StudentMapper {
    @Mapping(target = "regNumber", expression = "java(UUID.randomUUID().toString())")
    public abstract StudentEntity addUuid(StudentDto student);

    public abstract StudentDto mapToStudentDto(StudentEntity studentEntity);
}
