package com.sberteam.librarysustem.bootstrap;

import com.sberteam.librarysustem.models.AuthenticableUsers;
import com.sberteam.librarysustem.models.BasicUsers;
import com.sberteam.librarysustem.models.Roles;
import com.sberteam.librarysustem.repositories.AuthenticableUsersRepository;
import com.sberteam.librarysustem.repositories.BasicUsersRepository;
import com.sberteam.librarysustem.repositories.RolesRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataBaseTEst implements ApplicationListener<ContextRefreshedEvent> {

    AuthenticableUsersRepository authenticableUsersRepository;
    BasicUsersRepository basicUsersRepository;
    RolesRepository rolesRepository;

    public DataBaseTEst(AuthenticableUsersRepository authenticableUsersRepository, BasicUsersRepository basicUsersRepository, RolesRepository rolesRepository) {
        this.authenticableUsersRepository = authenticableUsersRepository;
        this.basicUsersRepository = basicUsersRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Roles roles = new Roles();
        roles.setName("ROLE_GUEST");
        rolesRepository.save(roles);


        AuthenticableUsers user = new AuthenticableUsers();
        user.setPatronomyc("batyaUsera");
        user.setName("user");
        user.setUsername("kasya");
        user.setPassword("123");
        user.setName("USER AUTH");
        user.setSurname("USER AUTHs");
        user.setRoles(new HashSet<Roles>());
        user.getRoles().add(roles);
        BasicUsers basicUser = new BasicUsers();
        basicUser.setPatronomyc("kasyaUsera");
        basicUser.setName("kasya");
        basicUser.setSurname("kasyaS");



        authenticableUsersRepository.save(user);
        basicUsersRepository.save(basicUser);


        List<BasicUsers> basicUsers =  new ArrayList<>();

        Iterator<BasicUsers> usersIterator = basicUsersRepository.findAll().iterator();
        while(usersIterator.hasNext()){
            System.out.println(usersIterator.next());
        }

        System.out.println("---------------------------------------------------------");

        List<AuthenticableUsers> authenticableUsers =  new ArrayList<>();

        Iterator<AuthenticableUsers> authenticableUsersIterator  = authenticableUsersRepository.findAll().iterator();
        while(authenticableUsersIterator.hasNext()){
            System.out.println(authenticableUsersIterator.next());
        }

    }
}
