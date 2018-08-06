package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.BasicUsers;
import com.sberteam.librarysustem.models.Roles;
import com.sberteam.librarysustem.models.BooksCategories;
import com.sberteam.librarysustem.repositories.BasicUsersRepository;
import com.sberteam.librarysustem.repositories.RolesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping(value = "/rest/basicusers",produces = "application/json")
public class BasicUserRestController {

    BasicUsersRepository basicUsersRepository;

    RolesRepository rolesRepository;

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

    @GetMapping(path = "/getUsersByRoleId")
    public Set<BasicUsers> getUsersByRoleId(@RequestParam Long id){
        Optional<Roles> rolesOptional = rolesRepository.findById(id);
                if(!rolesOptional.isPresent())
                    return null;
                Roles role = rolesOptional.get();
        Set<BasicUsers> returnUsers = new HashSet<>();
        Iterable<BasicUsers> users = basicUsersRepository.findAll();
        Iterator<BasicUsers> iterator = users.iterator();

        BasicUsers user;
        while (iterator.hasNext()){
            user = iterator.next();
            if(user.getRoles().contains(role))
                returnUsers.add(user);
        }

       return returnUsers;
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
