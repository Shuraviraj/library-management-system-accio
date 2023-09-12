package com.shuravi.librarymanagementsystemaccio.input;


import com.shuravi.librarymanagementsystemaccio.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorInput {
    String name;
    Integer age;
    String email;
    Gender gender;
}
