package com.sberteam.librarysustem.bootstrap;

import com.sberteam.librarysustem.models.*;
import com.sberteam.librarysustem.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataBaseTEst implements ApplicationListener<ContextRefreshedEvent> {

    public DataBaseTEst(AuthenticableUsersRepository authenticableUsersRepository, BasicUsersRepository basicUsersRepository,
                        RolesRepository rolesRepository, DocTypesRepository docTypesRepository,
                        BooksRepositories booksRepositories, PartiesRepository partiesRepository, ProvidersRepository providersRepository) {
        this.authenticableUsersRepository = authenticableUsersRepository;
        this.basicUsersRepository = basicUsersRepository;
        this.rolesRepository = rolesRepository;
        this.docTypesRepository = docTypesRepository;
        this.booksRepositories = booksRepositories;
        this.partiesRepository = partiesRepository;
        this.providersRepository = providersRepository;
    }

    private AuthenticableUsersRepository authenticableUsersRepository;
    private BasicUsersRepository basicUsersRepository;
    private RolesRepository rolesRepository;
    private DocTypesRepository docTypesRepository;
    private BooksRepositories booksRepositories;
    private PartiesRepository partiesRepository;
    private ProvidersRepository providersRepository;



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
        ///////////////////////////////////
        DocTypes docTypes = new DocTypes("Дар");
        docTypesRepository.save(docTypes);

        Providers provider = new Providers("Консульство Латвии");
        providersRepository.save(provider);

        Set<Books> books = new HashSet<>();
        books.add(new Books("Name"));
        booksRepositories.saveAll(books);

        Parties parties = new Parties(new Date(), docTypes, "Note",new Date(),docTypes, 10l,1000f,provider,"Дома пушкина",
                "Куда то вдаль",books);
        partiesRepository.save(parties);
    }
}
