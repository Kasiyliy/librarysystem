package com.sberteam.librarysustem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/basicusers")
/*
* Манипуляция данными происходит в РЕСТ контроллере
* */
public class BasicUsersController {

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {
        ModelAndView mw = new ModelAndView("admin/basicusers/index");
        return mw;
    }

}

