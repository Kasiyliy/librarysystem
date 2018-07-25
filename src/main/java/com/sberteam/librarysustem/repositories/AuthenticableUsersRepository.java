package com.sberteam.librarysustem.repositories;

import com.sberteam.librarysustem.models.AuthenticableUsers;
import com.sberteam.librarysustem.models.BasicUsers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AuthenticableUsersRepository extends CrudRepository<AuthenticableUsers, Long>{

    @Query("select a from AuthenticableUsers a where a.username = :username and a.password = :password and a.active = true")
    Stream<AuthenticableUsers> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);


    @Query("select a from AuthenticableUsers a where a.username = :username and a.active = true ")
    AuthenticableUsers findByUsername(@Param("username") String username);
}