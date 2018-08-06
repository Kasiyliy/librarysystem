package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.DocTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocTypesRepository extends CrudRepository<DocTypes,Long> {
}
