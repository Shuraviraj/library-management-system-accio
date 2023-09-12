package com.shuravi.librarymanagementsystemaccio.entity;

import com.shuravi.librarymanagementsystemaccio.enums.Genre;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "no_of_pages", nullable = false)
    Integer noOfPages;

    @Enumerated
    @Column(name = "genre", nullable = false)
    Genre genre;

    @Column(name = "cost", nullable = false)
    Double cost;

    @ManyToOne
    @JoinColumn(name = "author_id")
    AuthorEntity author;

    @Column(name = "issued")
    Boolean issued;

    @OneToMany(mappedBy = "bookEntity", cascade = CascadeType.ALL)
    List<TransactionEntity> transactionEntities = new ArrayList<>();

}
