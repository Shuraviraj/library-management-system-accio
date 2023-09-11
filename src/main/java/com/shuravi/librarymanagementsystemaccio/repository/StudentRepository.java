package com.shuravi.librarymanagementsystemaccio.repository;

import com.shuravi.librarymanagementsystemaccio.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
    @Query("select s from StudentEntity s where s.rollNumber = ?1")
    List<StudentEntity> findByrollNumber(int roll);
}
