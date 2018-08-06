package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.BooksCategories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksCategoriesRepository extends CrudRepository<BooksCategories,Long> {
}
