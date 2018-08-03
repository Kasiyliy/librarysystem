package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.models.Gender;
import com.sberteam.librarysustem.models.Roles;
import com.sberteam.librarysustem.repositories.GenderRepository;
import com.sberteam.librarysustem.repositories.RolesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/genders")
public class GendersController {


    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("admin/genders/index");
        return mw;
    }

}