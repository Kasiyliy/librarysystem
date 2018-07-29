package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.BasicUsers;
import com.sberteam.librarysustem.repositories.BasicUsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;
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

    @GetMapping(path = "/users/getUserById",produces = "application/json")
    public BasicUsers getUserById(@RequestParam Long id){
        Optional<BasicUsers> user = basicUsersRepository.findById(id);
        if(basicUsersRepository.findById(id).isPresent()){
            return user.get();
        }
        else return null;
    }

}
