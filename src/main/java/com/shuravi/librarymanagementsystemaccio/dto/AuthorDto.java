package com.shuravi.librarymanagementsystemaccio.dto;

import com.shuravi.librarymanagementsystemaccio.enums.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AuthorDto {
    Long id;
    String name;
    Integer age;
    String email;
    Date lastActivity;
    Gender gender;
    List<BookDto> books = new LinkedList<>();
}
