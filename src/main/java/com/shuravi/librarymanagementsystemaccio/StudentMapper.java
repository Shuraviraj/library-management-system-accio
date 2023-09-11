package com.shuravi.librarymanagementsystemaccio;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    imports = {UUID.class})
public abstract class StudentMapper {
  @Mapping(target = "regNumber", expression = "java(UUID.randomUUID().toString())")
  public abstract StudentEntity addUuid(StudentDto student);

  public abstract StudentDto mapToStudentDto(StudentEntity studentEntity);
}
