package com.shuravi.librarymanagementsystemaccio.model;

import com.shuravi.librarymanagementsystemaccio.enums.CardStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "library_card")
public class LibraryCardEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "card_number")
    String cardNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_status")
    CardStatus cardStatus;

    @CreatedDate
    @Column(name = "issue_date")
    Date issueDate;

    @OneToOne
    @JoinColumn(name = "student_id")
    StudentEntity student;
}