package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.BasicUsers;
import com.sberteam.librarysustem.repositories.BasicUsersRepository;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;


@RestController
public class UserRestController {

    BasicUsersRepository basicUsersRepository;

    public UserRestController(BasicUsersRepository basicUsersRepository){
        this.basicUsersRepository = basicUsersRepository;
    }

    @GetMapping(path = "/users/getAllUsers",produces = "application/json")
    public Set<BasicUsers> getAllUsers(){
        Set<BasicUsers> users = new HashSet<>();
        basicUsersRepository.findAll().forEach(users :: add);
        return users;
    }

    @GetMapping(path = "/users/getUserById/{id}",produces = "application/json")
    public BasicUsers getUser(@PathVariable Long id){

        return basicUsersRepository.findById(id).get();
    }
}