package com.shuravi.librarymanagementsystemaccio.entity;

import com.shuravi.librarymanagementsystemaccio.enums.TransactionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "transaction_number", nullable = false, unique = true)
    String transactionNumber;

    @CreationTimestamp
    @Column(name = "transaction_time")
    Date transactionTime;

    @Enumerated(EnumType.STRING)
    TransactionStatus transactionStatus;

    @ManyToOne
    @JoinColumn(name = "book_id")
    BookEntity bookEntity;

    @ManyToOne
    @JoinColumn(name = "library_card_id")
    LibraryCardEntity libraryCardEntity;
}
