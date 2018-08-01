package com.sberteam.librarysustem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @GetMapping(path = {"/index", ""})
    public String getIndexPage() {
        return "index";
    }

    @GetMapping(path = {"books_categories"})
    public String getbooksCategories(){
        return "admin/booksCategories/index";
    }

    @GetMapping(path = {"books_maps"})
    public String getbooksMaps(){
        return "admin/booksMaps/index";
    }

    @GetMapping(path = {"books_levels"})
    public String getbooksLevels(){
        return "admin/booksLevels/index";
    }
}
