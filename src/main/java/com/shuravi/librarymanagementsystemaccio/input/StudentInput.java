package com.shuravi.librarymanagementsystemaccio.input;

import com.shuravi.librarymanagementsystemaccio.enums.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInput {
    int rollNumber;
    String name;
    int age;
    String email;
    Gender gender;
}
