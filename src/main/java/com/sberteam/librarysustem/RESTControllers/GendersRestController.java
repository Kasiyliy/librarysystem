package com.sberteam.librarysustem.RESTControllers;


import com.sberteam.librarysustem.models.BooksLevels;
import com.sberteam.librarysustem.models.Gender;
import com.sberteam.librarysustem.repositories.GenderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/rest/genders",produces = "application/json")
public class GendersRestController {

    private GenderRepository gendersRepository;

    public GendersRestController(GenderRepository gendersRepository){
        this.gendersRepository = gendersRepository;
    }

    @GetMapping("/getAll")
    public Iterable<Gender> getAll(){
        return gendersRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Gender getById(@PathVariable Long id){
        Optional<Gender> genders= gendersRepository.findById(id);
        return genders.orElse(null);
    }

    @PostMapping(path={"/insert"})
    public void insert(@RequestBody Gender gender){
        gendersRepository.save(gender);
    }

    @PutMapping(path={"/update/{id}"})
    public Gender update(@PathVariable("id") Long id,@RequestBody Gender gender){
        if(gendersRepository.findById(id).isPresent())
            gender = gendersRepository.save(gender);

        return gender;
    }

    @DeleteMapping(path={"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){
        if(gendersRepository.findById(id).isPresent())
            gendersRepository.deleteById(id);
    }

}
