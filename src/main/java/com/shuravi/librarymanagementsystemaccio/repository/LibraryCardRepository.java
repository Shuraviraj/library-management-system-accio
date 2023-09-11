package com.shuravi.librarymanagementsystemaccio.repository;

import com.shuravi.librarymanagementsystemaccio.model.LibraryCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCardEntity, String> {
}