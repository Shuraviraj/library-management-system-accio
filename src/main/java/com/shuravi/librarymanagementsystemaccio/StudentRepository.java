package com.shuravi.librarymanagementsystemaccio;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
  @Query("select s from StudentEntity s where s.rollNumber = ?1")
  List<StudentEntity> findByrollNumber(int roll);
}
