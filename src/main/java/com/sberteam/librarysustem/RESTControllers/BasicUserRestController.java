package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.BasicUsers;
import com.sberteam.librarysustem.models.BooksCategories;
import com.sberteam.librarysustem.repositories.BasicUsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping(value = "/rest/basicusers",produces = "application/json")
public class BasicUserRestController {

    BasicUsersRepository basicUsersRepository;

    public BasicUserRestController(BasicUsersRepository basicUsersRepository){
        this.basicUsersRepository = basicUsersRepository;
    }

    @GetMapping(path = "/getAllUsers")
    public Set<BasicUsers> getAllUsers(){
        Set<BasicUsers> users = new HashSet<>();
        basicUsersRepository.findAll().forEach(users :: add);
        return users;
    }

    @GetMapping(path = "/getUserById")
    public BasicUsers getUserById(@RequestParam Long id){
        Optional<BasicUsers> user = basicUsersRepository.findById(id);
        if(basicUsersRepository.findById(id).isPresent()){
            return user.get();
        }
        else return null;
    }

    @PostMapping(path={"/insert"})
    public void insert(@RequestBody BasicUsers basicUsers){
        basicUsersRepository.save(basicUsers);
    }

    @PutMapping(path={"/update/{id}"})
    public BasicUsers update(@PathVariable("id") Long id,@RequestBody BasicUsers basicUsers){
        if(basicUsersRepository.findById(id).isPresent())
            basicUsers = basicUsersRepository.save(basicUsers);

        return basicUsers;
    }

    @DeleteMapping(path={"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){
        if(basicUsersRepository.findById(id).isPresent())
            basicUsersRepository.deleteById(id);
    }

}
