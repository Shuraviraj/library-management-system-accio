package com.shuravi.librarymanagementsystemaccio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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
    String regNumber;

    @Column(name = "roll_number")
    int rollNumber;

    @Column(name = "student_name")
    String name;

    @Column(name = "student_age")
    int age;

    @Column(name = "student_email")
    String email;

    @Column(name = "student_gender")
    @Enumerated(EnumType.STRING)
    Gender gender;
}
