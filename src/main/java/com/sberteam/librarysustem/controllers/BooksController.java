package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.models.Books;
import com.sberteam.librarysustem.repositories.BooksRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Book;

@Controller
@RequestMapping(value = "/books")
public class BooksController {

    BooksRepositories booksRepositories;

    public BooksController(BooksRepositories booksRepositories) {
        this.booksRepositories = booksRepositories;
    }

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("admin/books/index");
        mw.addObject("books", booksRepositories.findAll());
        return mw;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView single(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/books/single");
        mw.addObject("book", booksRepositories.findById(id).get());
        return mw;
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/books/delete");
        mw.addObject("book", booksRepositories.findById(id).get());
        return mw;
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/books/update");
        mw.addObject("book", booksRepositories.findById(id).get());
        return mw;
    }


    @PostMapping(path = "/add")
    public String addBook(@RequestParam(name="name")String name){
        Books books = new Books();
        books.setName(name);
        booksRepositories.save(books);
        return "redirect:/books";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable(value = "id" )Long id) {
        booksRepositories.delete(booksRepositories.findById(id).get());
        return "redirect:/books";
    }

    @PostMapping(path = "/update/{id}")
    public String updateBook(@RequestParam(name="name")String name,@PathVariable(value = "id" )Long id){
        Books books = booksRepositories.findById(id).get();
        books.setName(name);
        booksRepositories.save(books);
        return "redirect:/books";
    }

}
