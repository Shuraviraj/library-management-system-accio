package com.shuravi.librarymanagementsystemaccio;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    int rollNumber;
    String name;
    int age;
    String email;
    Gender gender;
}
