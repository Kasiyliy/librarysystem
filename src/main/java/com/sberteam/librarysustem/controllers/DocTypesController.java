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

    DocTypesRepository doctypesRepository;

    public DocTypesController(DocTypesRepository doctypesRepository) {
        this.doctypesRepository = doctypesRepository;
    }

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("admin/doctypes/index");
        mw.addObject("doctypes", doctypesRepository.findAll());
        return mw;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView single(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/doctypes/single");
        mw.addObject("doctype", doctypesRepository.findById(id).get());
        return mw;
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/doctypes/delete");
        mw.addObject("doctype", doctypesRepository.findById(id).get());
        return mw;
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/doctypes/update");
        mw.addObject("doctype", doctypesRepository.findById(id).get());
        return mw;
    }


    @PostMapping(path = "/add")
    public String addBook(@RequestParam(name="name")String name){
        DocTypes doctypes = new DocTypes();
        doctypes.setName(name);
        doctypesRepository.save(doctypes);
        return "redirect:/doctypes";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable(value = "id" )Long id) {
        doctypesRepository.delete(doctypesRepository.findById(id).get());
        return "redirect:/doctypes";
    }

    @PostMapping(path = "/update/{id}")
    public String updateBook(@RequestParam(name="name")String name,@PathVariable(value = "id" )Long id){
        DocTypes doctypes = doctypesRepository.findById(id).get();
        doctypes.setName(name);
        doctypesRepository.save(doctypes);
        return "redirect:/doctypes";
    }

}
