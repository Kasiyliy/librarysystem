package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.BooksMaps;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksMapsRepository extends CrudRepository<BooksMaps,Long> {
}
