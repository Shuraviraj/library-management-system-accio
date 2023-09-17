package com.shuravi.librarymanagementsystemaccio.dto;

import com.shuravi.librarymanagementsystemaccio.enums.Genre;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookDto {
    String title;
    Integer noOfPages;
    Genre genre;
    Double cost;
    AuthorDto author;
}
