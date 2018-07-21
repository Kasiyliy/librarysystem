package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long>{

}