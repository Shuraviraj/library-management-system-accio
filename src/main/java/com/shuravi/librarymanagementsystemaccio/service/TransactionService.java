package com.shuravi.librarymanagementsystemaccio.service;

import com.shuravi.librarymanagementsystemaccio.dto.IssueBookResponse;
import com.shuravi.librarymanagementsystemaccio.entity.BookEntity;
import com.shuravi.librarymanagementsystemaccio.entity.StudentEntity;
import com.shuravi.librarymanagementsystemaccio.entity.TransactionEntity;
import com.shuravi.librarymanagementsystemaccio.enums.TransactionStatus;
import com.shuravi.librarymanagementsystemaccio.exception.BookNotAvailableException;
import com.shuravi.librarymanagementsystemaccio.exception.BookNotFoundException;
import com.shuravi.librarymanagementsystemaccio.exception.StudentNotFoundException;
import com.shuravi.librarymanagementsystemaccio.repository.BookRepository;
import com.shuravi.librarymanagementsystemaccio.repository.StudentRepository;
import com.shuravi.librarymanagementsystemaccio.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    TransactionRepository transactionRepository;

    public IssueBookResponse issueBook(Long bookId, String studentId) {
        var studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isEmpty()) {
            throw new StudentNotFoundException("Invalid Student Id");
        }

        var bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isEmpty()) {
            throw new BookNotFoundException("Invalid Book Id");
        }

        var book = bookOptional.get();
        if (Boolean.TRUE.equals(book.getIssued())) {
            throw new BookNotAvailableException("Book already issued");
        }

        //issue the book
        var student = studentOptional.get();

        //create Transaction
        var transaction = TransactionEntity.builder()
                .transactionNumber(UUID.randomUUID().toString())
                .transactionStatus(TransactionStatus.SUCCESS)
                .bookEntity(book)
                .libraryCardEntity(student.getLibraryCard())
                .build();

        var savedTransaction = transactionRepository.save(transaction);

        //update book
        book.setIssued(true);
        book.getTransactionEntities().add(savedTransaction);

        //card changes
        student.getLibraryCard().getTransactionEntities().add(savedTransaction);

        //save
        BookEntity savedBook = bookRepository.save(book);
        StudentEntity savedStudent = studentRepository.save(student);
        String s = "abc";
        
        return IssueBookResponse.builder()
                .bookName(savedBook.getTitle())
                .transactionStatus(savedTransaction.getTransactionStatus())
                .transactionTime(savedTransaction.getTransactionTime())
                .transactionNumber(savedTransaction.getTransactionNumber())
                .studentName(savedStudent.getName())
                .libraryCardNumber(savedStudent.getLibraryCard().getCardNo())
                .authorName(savedBook.getAuthor().getName())
                .build();
    }
}
