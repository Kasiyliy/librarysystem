package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.models.Books;
import com.sberteam.librarysustem.models.Providers;
import com.sberteam.librarysustem.repositories.BooksRepositories;
import com.sberteam.librarysustem.repositories.ProvidersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/providers")
public class ProvidersController {

    ProvidersRepository providersRepository;

    public ProvidersController(ProvidersRepository providersRepository) {
        this.providersRepository = providersRepository;
    }

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("admin/providers/index");
        mw.addObject("providers", providersRepository.findAll());
        return mw;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView single(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/providers/single");
        mw.addObject("provider", providersRepository.findById(id).get());
        return mw;
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/providers/delete");
        mw.addObject("provider", providersRepository.findById(id).get());
        return mw;
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/providers/update");
        mw.addObject("provider", providersRepository.findById(id).get());
        return mw;
    }


    @PostMapping(path = "/add")
    public String addBook(@RequestParam(name="name")String name){
        Providers providers = new Providers();
        providers.setName(name);
        providersRepository.save(providers);
        return "redirect:/providers";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable(value = "id" )Long id) {
        providersRepository.delete(providersRepository.findById(id).get());
        return "redirect:/providers";
    }

    @PostMapping(path = "/update/{id}")
    public String updateBook(@RequestParam(name="name")String name,@PathVariable(value = "id" )Long id){
        Providers providers = providersRepository.findById(id).get();
        providers.setName(name);
        providersRepository.save(providers);
        return "redirect:/providers";
    }

}
