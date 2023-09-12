package com.shuravi.librarymanagementsystemaccio.repository;

import com.shuravi.librarymanagementsystemaccio.entity.StudentEntity;
import com.shuravi.librarymanagementsystemaccio.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    @Query("select s from StudentEntity s where s.rollNumber = ?1")
    List<StudentEntity> findByRollNumber(int roll);

    @Query("select s from StudentEntity s where s.gender = ?1")
    List<StudentEntity> findByGender(Gender gender);

}
