package com.sberteam.librarysustem.controllers;


import com.sberteam.librarysustem.repositories.DocTypesRepository;
import com.sberteam.librarysustem.repositories.PartiesRepository;
import com.sberteam.librarysustem.repositories.ProvidersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/records")
public class RecordsController {
    DocTypesRepository docTypesRepository;
    PartiesRepository partiesRepository;
    ProvidersRepository providersRepository;

    public RecordsController(DocTypesRepository docTypesRepository, PartiesRepository partiesRepository, ProvidersRepository providersRepository) {
        this.docTypesRepository = docTypesRepository;
        this.partiesRepository = partiesRepository;
        this.providersRepository = providersRepository;
    }

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("records/index");

        mw.addObject("providers", providersRepository.findAll());
        mw.addObject("doctypes", docTypesRepository.findAll());
        mw.addObject("parties", partiesRepository.findAll());

        return mw;
    }
}
