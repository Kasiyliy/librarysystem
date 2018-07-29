package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.models.Providers;
import com.sberteam.librarysustem.models.Roles;
import com.sberteam.librarysustem.repositories.ProvidersRepository;
import com.sberteam.librarysustem.repositories.RolesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/roles")
public class RolesController {

    RolesRepository rolesRepository;

    public RolesController(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("admin/roles/index");
        mw.addObject("roles", rolesRepository.findAll());
        return mw;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView single(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/roles/single");
        mw.addObject("role", rolesRepository.findById(id).get());
        return mw;
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/roles/delete");
        mw.addObject("role", rolesRepository.findById(id).get());
        return mw;
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/roles/update");
        mw.addObject("role", rolesRepository.findById(id).get());
        return mw;
    }


    @PostMapping(path = "/add")
    public String addBook(@RequestParam(name="name")String name){
        Roles roles = new Roles();
        roles.setName(name);
        rolesRepository.save(roles);
        return "redirect:/roles";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable(value = "id" )Long id) {
        rolesRepository.delete(rolesRepository.findById(id).get());
        return "redirect:/roles";
    }

    @PostMapping(path = "/update/{id}")
    public String updateBook(@RequestParam(name="name")String name,@PathVariable(value = "id" )Long id){
        Roles roles = rolesRepository.findById(id).get();
        roles.setName(name);
        rolesRepository.save(roles);
        return "redirect:/roles";
    }

}
