package com.shuravi.librarymanagementsystemaccio.transformer;

import com.shuravi.librarymanagementsystemaccio.dto.LibraryCardDto;
import com.shuravi.librarymanagementsystemaccio.dto.StudentDto;
import com.shuravi.librarymanagementsystemaccio.dto.input.StudentInput;
import com.shuravi.librarymanagementsystemaccio.entity.StudentEntity;

import java.util.UUID;

public class StudentTransformer {
    public static StudentEntity StudentInputToStudentEntity(StudentInput studentInput) {

        return StudentEntity.builder()
                .regNumber(UUID.randomUUID().toString())
                .rollNumber(studentInput.getRollNumber())
                .name(studentInput.getName())
                .age(studentInput.getAge())
                .email(studentInput.getEmail())
                .gender(studentInput.getGender())
                .build();
    }

    public static StudentDto StudentEntityToStudentDto(StudentEntity studentEntity) {

        var cardResponse = LibraryCardDto.builder()
                .cardNo(studentEntity.getLibraryCard().getCardNo())
                .cardStatus(studentEntity.getLibraryCard().getCardStatus())
                .issueDate(studentEntity.getLibraryCard().getIssueDate())
                .build();

        return StudentDto.builder()
                .name(studentEntity.getName())
                .email(studentEntity.getEmail())
                .libraryCardDto(cardResponse)
                .build();
    }
}
