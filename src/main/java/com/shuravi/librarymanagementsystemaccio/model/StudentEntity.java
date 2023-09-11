package com.shuravi.librarymanagementsystemaccio.model;

import com.shuravi.librarymanagementsystemaccio.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @Column(name = "id")
    String regNumber;

    @Column(name = "roll_number")
    int rollNumber;

    @Column(name = "student_name", nullable = false)
    String name;

    @Column(name = "student_age", nullable = false)
    int age;

    @Column(name = "student_email", nullable = false, unique = true)
    String email;

    @Column(name = "student_gender", nullable = false)
    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    LibraryCardEntity libraryCard;
}
