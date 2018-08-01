package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.models.Books;
import com.sberteam.librarysustem.models.BooksCategories;
import com.sberteam.librarysustem.models.BooksMaps;
import com.sberteam.librarysustem.repositories.*;
import com.sberteam.librarysustem.utils.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping(value = "/books")
/*
* В принципе можно убрать удаление,добавление. написан REST controller
* */
public class BooksController {

    BooksRepository booksRepository;
    PartiesRepository partiesRepository;
    BooksCategoriesRepository booksCategoriesRepository;
    BooksLevelsRepository booksLevelsRepository;
    BooksMapsRepository booksMapsRepository;

    public BooksController(BooksRepository booksRepository, PartiesRepository partiesRepository, BooksCategoriesRepository booksCategoriesRepository,
                           BooksLevelsRepository booksLevelsRepository, BooksMapsRepository booksMapsRepository) {
        this.booksRepository = booksRepository;
        this.partiesRepository = partiesRepository;
        this.booksCategoriesRepository = booksCategoriesRepository;
        this.booksLevelsRepository = booksLevelsRepository;
        this.booksMapsRepository = booksMapsRepository;
    }



    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("admin/books/index");
        mw.addObject("books", booksRepository.findAll());
        mw.addObject("parties", partiesRepository.findAll());
        mw.addObject("categories",booksCategoriesRepository.findAll());
        mw.addObject("levels",booksLevelsRepository.findAll());
        mw.addObject("maps",booksMapsRepository.findAll());
        return mw;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView single(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/books/single");
        mw.addObject("book", booksRepository.findById(id).get());

        return mw;
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/books/delete");
        mw.addObject("book", booksRepository.findById(id).get());
        return mw;
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/books/update");

        mw.addObject("book", booksRepository.findById(id).get());
        mw.addObject("parties", partiesRepository.findAll());

        return mw;
    }


    @PostMapping(path = "/add")
    public String addBook(@RequestParam(name="name")String name,
                          @RequestParam(name="party_id")Long partyID,
                          @RequestParam(name = "author")String author,
                          @RequestParam(name = "category_id") Long category_id,
                          @RequestParam(name = "publisher") String publisher,
                          @RequestParam(name = "year") Long year,
                          @RequestParam(name = "publisher_place") String publication_place,
                          @RequestParam(name = "tom_number") Long tom_number,
                          @RequestParam(name = "map_id") Long map_id,
                          @RequestParam(name = "level_id") Long level_id,
                          @RequestParam(name = "count") Integer count,
                          @RequestParam(name = "price") Float price,
                          @RequestParam(name = "transfer_number") Long transfer_number
                          )

    {
             Books books = new Books(name,author,booksCategoriesRepository.findById(category_id).get(),publisher, CommonUtils.getDateFromString(year+"-01-01"),publication_place,tom_number,
                                booksMapsRepository.findById(map_id).get(),booksLevelsRepository.findById(level_id).get(),count,price,transfer_number,
                                partiesRepository.findById(partyID).get()
                );

        booksRepository.save(books);
        return "redirect:/books";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable(value = "id" )Long id) {
        booksRepository.delete(booksRepository.findById(id).get());
        return "redirect:/books";
    }

    @PostMapping(path = "/update/{id}")
    public String updateBook(@RequestParam(name="name")String name, @RequestParam(name="party_id")Long partyID,@PathVariable(value = "id" )Long id){
        Books books = booksRepository.findById(id).get();

        books.setName(name);
        books.setParty(partiesRepository.findById(partyID).get());

        booksRepository.save(books);
        return "redirect:/books";
    }

}
