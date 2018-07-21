package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.Gender;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends CrudRepository<Gender,Long>{
}
