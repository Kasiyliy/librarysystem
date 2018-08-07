package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/indicators")
public class ControlIndicatorsController {
    BooksRepository booksRepository;
    PartiesRepository partiesRepository;
    BooksCategoriesRepository booksCategoriesRepository;
    BooksLevelsRepository booksLevelsRepository;
    BooksMapsRepository booksMapsRepository;

    public ControlIndicatorsController(BooksRepository booksRepository, PartiesRepository partiesRepository, BooksCategoriesRepository booksCategoriesRepository,
                           BooksLevelsRepository booksLevelsRepository, BooksMapsRepository booksMapsRepository) {
        this.booksRepository = booksRepository;
        this.partiesRepository = partiesRepository;
        this.booksCategoriesRepository = booksCategoriesRepository;
        this.booksLevelsRepository = booksLevelsRepository;
        this.booksMapsRepository = booksMapsRepository;
    }



    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("/controlindicators/index");
        mw.addObject("books", booksRepository.findAll());
        mw.addObject("parties", partiesRepository.findAll());
        mw.addObject("categories",booksCategoriesRepository.findAll());
        mw.addObject("levels",booksLevelsRepository.findAll());
        mw.addObject("maps",booksMapsRepository.findAll());
        return mw;
    }
}
