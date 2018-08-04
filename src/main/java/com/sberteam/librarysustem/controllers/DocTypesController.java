package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.models.DocTypes;
import com.sberteam.librarysustem.models.Roles;
import com.sberteam.librarysustem.repositories.DocTypesRepository;
import com.sberteam.librarysustem.repositories.RolesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/doctypes")
public class DocTypesController {

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {
        ModelAndView mw = new ModelAndView("admin/doctypes/index");
        return mw;
    }

}
