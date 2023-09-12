package com.shuravi.librarymanagementsystemaccio.repository;

import com.shuravi.librarymanagementsystemaccio.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
