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

    GenderRepository gendersRepository;

    public GendersController(GenderRepository gendersRepository) {
        this.gendersRepository = gendersRepository;
    }

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("admin/genders/index");
        mw.addObject("genders", gendersRepository.findAll());
        return mw;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView single(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/genders/single");
        mw.addObject("gender", gendersRepository.findById(id).get());
        return mw;
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/genders/delete");
        mw.addObject("gender", gendersRepository.findById(id).get());
        return mw;
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/genders/update");
        mw.addObject("gender", gendersRepository.findById(id).get());
        return mw;
    }


    @PostMapping(path = "/add")
    public String addBook(@RequestParam(name="name")String name){
        Gender genders = new Gender();
        genders.setName(name);
        gendersRepository.save(genders);
        return "redirect:/genders";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable(value = "id" )Long id) {
        gendersRepository.delete(gendersRepository.findById(id).get());
        return "redirect:/genders";
    }

    @PostMapping(path = "/update/{id}")
    public String updateBook(@RequestParam(name="name")String name,@PathVariable(value = "id" )Long id){
        Gender genders = gendersRepository.findById(id).get();
        genders.setName(name);
        gendersRepository.save(genders);
        return "redirect:/genders";
    }

}