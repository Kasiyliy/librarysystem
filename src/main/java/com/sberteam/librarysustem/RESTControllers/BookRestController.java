package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.Books;
import com.sberteam.librarysustem.repositories.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/books")
public class BookRestController {
    BooksRepository booksRepository;
    PartiesRepository partiesRepository;
    BooksCategoriesRepository booksCategoriesRepository;
    BooksLevelsRepository booksLevelsRepository;
    BooksMapsRepository booksMapsRepository;

    public BookRestController(BooksRepository booksRepository, PartiesRepository partiesRepository, BooksCategoriesRepository booksCategoriesRepository,
                           BooksLevelsRepository booksLevelsRepository, BooksMapsRepository booksMapsRepository) {
        this.booksRepository = booksRepository;
        this.partiesRepository = partiesRepository;
        this.booksCategoriesRepository = booksCategoriesRepository;
        this.booksLevelsRepository = booksLevelsRepository;
        this.booksMapsRepository = booksMapsRepository;
    }

    @GetMapping(path = "/",produces = "application/json")
    public Set<Books> getAllBooks(){
        Set<Books> users = new HashSet<>();

        return null;
    }
}
