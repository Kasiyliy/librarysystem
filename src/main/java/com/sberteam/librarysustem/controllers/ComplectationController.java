package com.sberteam.librarysustem.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/complectation")
public class ComplectationController {

    @GetMapping(path={"/inputDocuments"})
    public ModelAndView inputDocuments() {
        ModelAndView mw = new ModelAndView("/complectation/inputDocuments");
        return mw;
    }


}
