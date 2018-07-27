package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.BasicUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicUsersRepository extends CrudRepository<BasicUsers, Long>{

}