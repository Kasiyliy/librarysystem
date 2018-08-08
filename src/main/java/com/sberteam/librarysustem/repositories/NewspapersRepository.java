package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.Newspapers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewspapersRepository extends CrudRepository<Newspapers,Long> {
}
