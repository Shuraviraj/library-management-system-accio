package com.shuravi.librarymanagementsystemaccio.model;

import com.shuravi.librarymanagementsystemaccio.enums.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    @Column(name = "issue_date")
    Date issueDate;

    @OneToOne
    @JoinColumn(name = "student_id")
    StudentEntity student;
}
