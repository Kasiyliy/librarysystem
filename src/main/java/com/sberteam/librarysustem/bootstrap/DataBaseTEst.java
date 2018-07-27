package com.sberteam.librarysustem.bootstrap;

import com.sberteam.librarysustem.models.AuthenticableUsers;
import com.sberteam.librarysustem.models.BasicUsers;
import com.sberteam.librarysustem.models.Roles;
import com.sberteam.librarysustem.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataBaseTEst implements ApplicationListener<ContextRefreshedEvent> {

    private AuthenticableUsersRepository authenticableUsersRepository;
    private BasicUsersRepository basicUsersRepository;
    private RolesRepository rolesRepository;
    private DocTypesRepository docTypesRepository;
    private BooksRepositories booksRepositories;
    private PartiesRepository partiesRepository;
    private ProvidersRepository providersRepository;


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
        user.setPassword(new BCryptPasswordEncoder().encode("123"));
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


    }
}
