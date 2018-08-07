package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.Parties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartiesRepository extends CrudRepository<Parties,Long> {

}
