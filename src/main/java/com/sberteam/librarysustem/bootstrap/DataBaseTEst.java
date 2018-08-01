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


    private AuthenticableUsersRepository authenticableUsersRepository;
    private BasicUsersRepository basicUsersRepository;
    private RolesRepository rolesRepository;
    private DocTypesRepository docTypesRepository;
    private BooksRepository booksRepository;
    private PartiesRepository partiesRepository;
    private ProvidersRepository providersRepository;
    private BooksCategoriesRepository booksCategoriesRepository;
    private BooksMapsRepository booksMapsRepository;
    private BooksLevelsRepository booksLevelsRepository;


    public DataBaseTEst(AuthenticableUsersRepository authenticableUsersRepository, BasicUsersRepository basicUsersRepository,
                        RolesRepository rolesRepository, DocTypesRepository docTypesRepository,
                        BooksRepository booksRepository, PartiesRepository partiesRepository, ProvidersRepository providersRepository,
                        BooksCategoriesRepository booksCategoriesRepository,
                        BooksLevelsRepository booksLevelsRepository,
                        BooksMapsRepository booksMapsRepository) {
        this.authenticableUsersRepository = authenticableUsersRepository;
        this.basicUsersRepository = basicUsersRepository;
        this.rolesRepository = rolesRepository;
        this.docTypesRepository = docTypesRepository;
        this.booksRepository = booksRepository;
        this.partiesRepository = partiesRepository;
        this.providersRepository = providersRepository;
        this.booksCategoriesRepository = booksCategoriesRepository;
        this.booksLevelsRepository = booksLevelsRepository;
        this.booksMapsRepository = booksMapsRepository;
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
        ///////////////////////////////////
        DocTypes docTypes = new DocTypes("Дар");
        docTypesRepository.save(docTypes);

        Providers provider = new Providers("Консульство Латвии");
        providersRepository.save(provider);

        BooksCategories booksCategory = new BooksCategories("TestCat");
        booksCategoriesRepository.save(booksCategory);

        BooksMaps  booksMap = new BooksMaps("TestMap");
        booksMapsRepository.save(booksMap);

        BooksLevels booksLevels = new BooksLevels("TestLevel");
        booksLevelsRepository.save(booksLevels);

        Parties parties = new Parties("Party number "+ new Date() ,new Date(), docTypes, "Note",new Date(),docTypes, provider,"Дома пушкина",
                "Куда то вдаль");
        partiesRepository.save(parties);

        Books books = new Books("name","author",booksCategory,"publisher",new Date(),
                "place",1222333l, booksMap,booksLevels,
                4  , 25f, 23l, parties);

        booksRepository.save(books);
    }
}
