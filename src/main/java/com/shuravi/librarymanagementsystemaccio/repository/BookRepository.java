package com.shuravi.librarymanagementsystemaccio.repository;

import com.shuravi.librarymanagementsystemaccio.entity.BookEntity;
import com.shuravi.librarymanagementsystemaccio.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
//    @Query("select b from BookEntity b where b.genre = ?1 and b.cost > ?2")
//    List<BookEntity> findByGenreAndCostGreaterThan(Genre genre, Double cost);

    @Query(value = "select * from book where genre = :genre and cost > :cost", nativeQuery = true)
    List<BookEntity> findByGenreAndCostGreaterThan(String genre, Double cost);

    @Query(value = "select b from BookEntity b where b.genre = :genre and b.cost > :cost")
    List<BookEntity> findByGenreAndCostGreaterThanHql(Genre genre, Double cost);

}
