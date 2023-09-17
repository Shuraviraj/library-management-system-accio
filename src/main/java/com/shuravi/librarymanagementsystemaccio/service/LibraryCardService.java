package com.shuravi.librarymanagementsystemaccio.service;

import com.shuravi.librarymanagementsystemaccio.entity.LibraryCardEntity;
import com.shuravi.librarymanagementsystemaccio.entity.StudentEntity;
import com.shuravi.librarymanagementsystemaccio.mapper.LibraryMapper;
import com.shuravi.librarymanagementsystemaccio.repository.LibraryCardRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibraryCardService {
    @Autowired
    LibraryCardRepository libraryCardRepoSitory;
    @Autowired
    LibraryMapper libraryMapper;

    @Transactional
    public LibraryCardEntity createLibraryCard(StudentEntity studentEntity) {
        return libraryMapper.createLibraryCardEntity(studentEntity);
    }
}
