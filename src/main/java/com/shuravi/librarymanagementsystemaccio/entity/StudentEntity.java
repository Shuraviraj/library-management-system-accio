package com.shuravi.librarymanagementsystemaccio.entity;

import com.shuravi.librarymanagementsystemaccio.enums.Gender;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    Integer rollNumber;

    @Column(name = "student_name", nullable = false)
    String name;

    @Column(name = "student_age", nullable = false)
    Integer age;

    @Column(name = "student_email", nullable = false, unique = true)
    String email;

    @Column(name = "student_gender", nullable = false)
    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    LibraryCardEntity libraryCard;
}
