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
* Манипуляция данными происходит в РЕСТ контроллере
* */
public class BooksController {

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {
        ModelAndView mw = new ModelAndView("admin/books/index");
        return mw;
    }

}

