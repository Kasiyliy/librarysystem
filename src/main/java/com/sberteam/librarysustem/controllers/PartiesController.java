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

    DocTypesRepository docTypesRepository;
    PartiesRepository partiesRepository;
    ProvidersRepository providersRepository;

    public PartiesController(DocTypesRepository docTypesRepository, PartiesRepository partiesRepository, ProvidersRepository providersRepository) {
        this.docTypesRepository = docTypesRepository;
        this.partiesRepository = partiesRepository;
        this.providersRepository = providersRepository;
    }

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {

        ModelAndView mw = new ModelAndView("admin/parties/index");

        mw.addObject("providers", providersRepository.findAll());
        mw.addObject("doctypes", docTypesRepository.findAll());
        mw.addObject("parties", partiesRepository.findAll());

        return mw;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView single(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/parties/single");
        mw.addObject("party", partiesRepository.findById(id).get());

        return mw;
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/parties/delete");
        mw.addObject("party", partiesRepository.findById(id).get());
        return mw;
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable(value = "id" )Long id) {
        ModelAndView mw = new ModelAndView("admin/parties/update");

        mw.addObject("party", partiesRepository.findById(id).get());
        mw.addObject("providers", providersRepository.findAll());
        mw.addObject("doctypes", docTypesRepository.findAll());

        return mw;
    }


    @PostMapping(path = "/add")
    public String addParty(
            @RequestParam(name="name")String name, @RequestParam(name="deliverydate")String deliverydate,
            @RequestParam(name="source_doctypes_id") Long source_doctypes_id ,@RequestParam(name="note") String note ,
            @RequestParam(name="datebydoc") String datebydoc ,@RequestParam(name="doctypes_id") Long doctypes_id ,
            @RequestParam(name="provider_id") Long provider_id ,@RequestParam(name="address") String address ,
            @RequestParam(name="transfer") String transfer
            ){
        Parties parties = new Parties();

        parties.setName(name);
        parties.setSourceDocType(docTypesRepository.findById(source_doctypes_id).get());
        parties.setDocTypes(docTypesRepository.findById(doctypes_id).get());
        parties.setDateByDoc(CommonUtils.getDateFromString(datebydoc));
        parties.setProvider(providersRepository.findById(provider_id).get());
        parties.setNote(note);
        parties.setDeliveryDate(CommonUtils.getDateFromString(deliverydate));
        parties.setAddress(address);
        parties.setTransfer(transfer);

        partiesRepository.save(parties);

        return "redirect:/parties";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteParty(@PathVariable(value = "id" )Long id) {
        partiesRepository.delete(partiesRepository.findById(id).get());
        return "redirect:/parties";
    }

    @PostMapping(path = "/update/{id}")
    public String updateParty(
            @RequestParam(name="name")String name, @RequestParam(name="deliverydate")String deliverydate,
            @RequestParam(name="source_doctypes_id") Long source_doctypes_id ,@RequestParam(name="note") String note ,
            @RequestParam(name="datebydoc") String datebydoc ,@RequestParam(name="doctypes_id") Long doctypes_id ,
            @RequestParam(name="provider_id") Long provider_id ,@RequestParam(name="address") String address ,
            @RequestParam(name="transfer") String transfer,@PathVariable(value = "id" )Long id){

        Parties parties = partiesRepository.findById(id).get();

        parties.setName(name);
        parties.setSourceDocType(docTypesRepository.findById(source_doctypes_id).get());
        parties.setDocTypes(docTypesRepository.findById(doctypes_id).get());
        parties.setDateByDoc(CommonUtils.getDateFromString(datebydoc));
        parties.setProvider(providersRepository.findById(provider_id).get());
        parties.setNote(note);
        parties.setDeliveryDate(CommonUtils.getDateFromString(deliverydate));
        parties.setAddress(address);
        parties.setTransfer(transfer);

        partiesRepository.save(parties);
        return "redirect:/parties";
    }

}
