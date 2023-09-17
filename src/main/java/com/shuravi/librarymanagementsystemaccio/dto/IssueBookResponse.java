package com.shuravi.librarymanagementsystemaccio.dto;

import com.shuravi.librarymanagementsystemaccio.enums.TransactionStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IssueBookResponse {
    String transactionNumber;
    Date transactionTime;
    TransactionStatus transactionStatus;
    String bookName;
    String authorName;
    String studentName;
    String libraryCardNumber;
}
