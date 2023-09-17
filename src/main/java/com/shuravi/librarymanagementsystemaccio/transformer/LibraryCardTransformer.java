package com.shuravi.librarymanagementsystemaccio.transformer;

import com.shuravi.librarymanagementsystemaccio.entity.LibraryCardEntity;
import com.shuravi.librarymanagementsystemaccio.enums.CardStatus;

import java.util.UUID;

public class LibraryCardTransformer {
    public static LibraryCardEntity prepareLibraryCard() {
        return LibraryCardEntity.builder()
                .cardNo(String.valueOf(UUID.randomUUID()))
                .cardStatus(CardStatus.ACTIVE)
                .build();
    }
}
