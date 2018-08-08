package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.BooksLevels;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksLevelsRepository extends CrudRepository<BooksLevels,Long> {
}
