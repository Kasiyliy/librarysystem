package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books,Long> {
}