package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.models.Books;
import com.sberteam.librarysustem.models.Parties;
import com.sberteam.librarysustem.repositories.BooksRepository;
import com.sberteam.librarysustem.repositories.DocTypesRepository;
import com.sberteam.librarysustem.repositories.PartiesRepository;
import com.sberteam.librarysustem.repositories.ProvidersRepository;
import com.sberteam.librarysustem.utils.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping(value = "/parties")
public class PartiesController {

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("admin/parties/index");
        return mw;
    }

}
