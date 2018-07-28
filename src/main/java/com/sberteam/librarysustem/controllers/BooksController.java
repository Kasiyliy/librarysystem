package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.repositories.BooksRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/books")
public class BooksController {

    BooksRepositories booksRepositories;

    public BooksController(BooksRepositories booksRepositories) {
        this.booksRepositories = booksRepositories;
    }

    @GetMapping(path = "/")
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("admin/books/index");
        mw.addObject("books", booksRepositories.findAll());

        return mw;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView single(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/books/single");
        mw.addObject("book", booksRepositories.findById(id));
        return mw;
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/books/delete");
        mw.addObject("book", booksRepositories.findById(id));
        return mw;
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/books/update");
        mw.addObject("book", booksRepositories.findById(id));
        return mw;
    }

}
