package com.sberteam.librarysustem.RESTControllers;


import com.sberteam.librarysustem.models.Gender;
import com.sberteam.librarysustem.models.Languages;
import com.sberteam.librarysustem.repositories.GenderRepository;
import com.sberteam.librarysustem.repositories.LanguagesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/rest/languages",produces = "application/json")
public class LanguagesRestController {

    private LanguagesRepository languagesRepository;

    public LanguagesRestController(LanguagesRepository languagesRepository){
        this.languagesRepository = languagesRepository;
    }

    @GetMapping("/getAll")
    public Iterable<Languages> getAll(){
        return languagesRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Languages getById(@PathVariable Long id){
        Optional<Languages> genders= languagesRepository.findById(id);
        return genders.orElse(null);
    }

    @PostMapping(path={"/insert"})
    public void insert(@RequestBody Languages language){
        languagesRepository.save(language);
    }

    @PutMapping(path={"/update/{id}"})
    public Languages update(@PathVariable("id") Long id,@RequestBody Languages language){
        if(languagesRepository.findById(id).isPresent())
            language = languagesRepository.save(language);

        return language;
    }

    @DeleteMapping(path={"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){
        if(languagesRepository.findById(id).isPresent())
            languagesRepository.deleteById(id);
    }

}
