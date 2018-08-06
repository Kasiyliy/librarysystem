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

        Roles role_guest = new Roles();
        role_guest.setName("ROLE_GUEST");

        Roles role_admin = new Roles();
        role_admin.setName("ROLE_ADMIN");

        rolesRepository.save(role_guest);
        rolesRepository.save(role_admin);

        AuthenticableUsers user = new AuthenticableUsers();
        user.setPatronomyc("batyaUsera");
        user.setName("user");
        user.setUsername("kasya");
        user.setPassword(new BCryptPasswordEncoder().encode("123"));
        user.setName("USER AUTH");
        user.setSurname("USER AUTHs");
        user.setRoles(new HashSet<Roles>());
        user.getRoles().add(role_guest);
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

        Parties parties = new Parties(13213L,new Date(), docTypes, "Note", 351351L, new Date(),docTypes, 10, 2000f, provider,"Дома пушкина",
                "Куда то вдаль");
        partiesRepository.save(parties);

        Books books = new Books("name","author",booksCategory,"publisher",new Date(),
                "place",1222333l, booksMap,booksLevels,
                4  , 25f, 23l, parties);


        DocTypes docTypes2 = new DocTypes("Подписка");
        docTypesRepository.save(docTypes2);

        DocTypes docTypes3 = new DocTypes("Покупкa");
        docTypesRepository.save(docTypes3);

        Providers provider2 = new Providers("Издание СНГ");
        providersRepository.save(provider2);

        BooksCategories booksCategory2 = new BooksCategories("Журналы");
        booksCategoriesRepository.save(booksCategory2);

        BooksMaps  booksMap2 = new BooksMaps("Казахстан");
        booksMapsRepository.save(booksMap2);

        BooksLevels booksLevels2 = new BooksLevels("TestLevel 2");
        booksLevelsRepository.save(booksLevels2);

//        Parties parties2 = new Parties("Party number "+ new Date() ,new Date(), docTypes2, "Note",new Date(),docTypes2, provider2,"Дома пушкина",
//                "Куда то вдаль");
//        partiesRepository.save(parties2);





        Providers provider3 = new Providers("Зарубежные Издание");
        providersRepository.save(provider3);

        BooksCategories booksCategory3 = new BooksCategories("Книги");
        booksCategoriesRepository.save(booksCategory3);

        BooksMaps  booksMap3 = new BooksMaps("Россия");
        booksMapsRepository.save(booksMap3);

        BooksLevels booksLevels3 = new BooksLevels("TestLevel 3");
        booksLevelsRepository.save(booksLevels3);

//        Parties parties3 = new Parties("Party number "+ new Date() ,new Date(), docTypes, "Note",new Date(),docTypes2, provider3,"мк-н Мамыр-2",
//                "Шаляпина 202а");
//        partiesRepository.save(parties3);



        Providers provider4 = new Providers("Издание Казахстана");
        providersRepository.save(provider4);

        BooksCategories booksCategory4 = new BooksCategories("Энциклопедии");
        booksCategoriesRepository.save(booksCategory4);

        BooksMaps  booksMap4 = new BooksMaps("Англия");
        booksMapsRepository.save(booksMap4);

        BooksLevels booksLevels4 = new BooksLevels("TestLevel 4");
        booksLevelsRepository.save(booksLevels4);

//        Parties parties4 = new Parties("Party number "+ new Date() ,new Date(), docTypes2, "Note",new Date(),docTypes2, provider4,"мк-н Мамыр-2",
//                "мк-н Жетысу-4");
//        partiesRepository.save(parties4);


        Providers provider5 = new Providers("American Books");
        providersRepository.save(provider5);

        BooksCategories booksCategory5 = new BooksCategories("Учебники");
        booksCategoriesRepository.save(booksCategory5);

        BooksMaps  booksMap5 = new BooksMaps("США");
        booksMapsRepository.save(booksMap4);

        BooksLevels booksLevels5 = new BooksLevels("TestLevel 4");
        booksLevelsRepository.save(booksLevels4);

//        Parties parties5 = new Parties("Party number "+ new Date() ,new Date(), docTypes2, "Note",new Date(),docTypes2, provider5,"мк-н Мамыр-2",
//                "Сатпаева 909");
//        partiesRepository.save(parties5);



        Providers provider6 = new Providers("Росмэн");
        providersRepository.save(provider6);

        BooksCategories booksCategory6 = new BooksCategories("Энциклопедии");
        booksCategoriesRepository.save(booksCategory6);

        BooksLevels booksLevels6 = new BooksLevels("TestLevel 4");
        booksLevelsRepository.save(booksLevels6);

//        Parties parties6 = new Parties("Party number "+ new Date() ,new Date(), docTypes2, "Note",new Date(),docTypes2, provider6,"мк-н Мамыр-2",
//                "Жандосова 2");
//        partiesRepository.save(parties6);


        Providers provider7 = new Providers("ТОО Крос-Пресс");
        providersRepository.save(provider7);

        BooksCategories booksCategory7 = new BooksCategories("Энциклопедии");
        booksCategoriesRepository.save(booksCategory7);

        BooksLevels booksLevels7 = new BooksLevels("TestLevel 4");
        booksLevelsRepository.save(booksLevels7);

//        Parties parties7 = new Parties("Party number "+ new Date() ,new Date(), docTypes2, "Note",new Date(),docTypes2, provider4,"мк-н Мамыр-2",
//                "Жандосова 2");
//        partiesRepository.save(parties7);



        Providers provider8 = new Providers("ТОО Книжный центр Эрудит");
        providersRepository.save(provider8);

        BooksCategories booksCategory8 = new BooksCategories("Энциклопедии");
        booksCategoriesRepository.save(booksCategory8);

        BooksLevels booksLevels8 = new BooksLevels("TestLevel 4");
        booksLevelsRepository.save(booksLevels8);

//        Parties parties8 = new Parties("Party number "+ new Date() ,new Date(), docTypes2, "Note",new Date(),docTypes2, provider4,"мк-н Мамыр-2",
//                "Жандосова 2");
//        partiesRepository.save(parties8);

        booksRepository.save(books);
    }
}
