package com.shuravi.librarymanagementsystemaccio.input;

import com.shuravi.librarymanagementsystemaccio.enums.Genre;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookInput {
    String title;
    Integer noOfPages;
    Genre genre;
    Double cost;
}
