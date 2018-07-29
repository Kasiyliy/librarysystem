package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.models.Books;
import com.sberteam.librarysustem.repositories.BooksRepository;
import com.sberteam.librarysustem.repositories.PartiesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/books")
public class BooksController {

    BooksRepository booksRepository;
    PartiesRepository partiesRepository;

    public BooksController(BooksRepository booksRepository, PartiesRepository partiesRepository) {
        this.booksRepository = booksRepository;
        this.partiesRepository = partiesRepository;
    }

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("admin/books/index");
        mw.addObject("books", booksRepository.findAll());
        mw.addObject("parties", partiesRepository.findAll());

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
    public String addBook(@RequestParam(name="name")String name, @RequestParam(name="party_id")Long partyID){
        Books books = new Books();
        books.setName(name);
        books.setParty(partiesRepository.findById(partyID).get());
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
