package com.shuravi.librarymanagementsystemaccio.mapper;

import com.shuravi.librarymanagementsystemaccio.dto.StudentDto;
import com.shuravi.librarymanagementsystemaccio.input.StudentInput;
import com.shuravi.librarymanagementsystemaccio.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.UUID;

@Mapper(
        componentModel = "spring",
        imports = {UUID.class},
        uses = {LibraryMapper.class})
public abstract class StudentMapper {
    @Mapping(target = "regNumber", expression = "java(UUID.randomUUID().toString())")
    public abstract StudentEntity createStudentEntity(StudentInput student);

    @Mapping(target = "libraryCardDto", source = "libraryCard")
    public abstract StudentDto mapToStudentDto(StudentEntity studentEntity);

    @Mapping(target = "age", source = "newAge")
    public abstract StudentEntity mapNewAge(@MappingTarget StudentEntity studentEntity, Integer newAge);
}
