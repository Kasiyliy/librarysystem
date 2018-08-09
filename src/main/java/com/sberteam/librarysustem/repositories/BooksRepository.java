package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BooksRepository extends CrudRepository<Books,Long> {
    @Query("select a from Books a where a.year >= :from and :to <= a.year and a.language.id = :language")
    List<Books> queryFromTo(@Param("from")Date from, @Param("to")Date to,@Param("language")long language);
}
