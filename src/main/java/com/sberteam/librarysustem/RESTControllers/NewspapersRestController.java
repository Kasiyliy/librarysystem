package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.Newspapers;
import com.sberteam.librarysustem.repositories.NewspapersRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/rest/newspapers",produces = "application/json")
public class NewspapersRestController {

    private NewspapersRepositories newspapersRepository;

    public NewspapersRestController (NewspapersRepositories newspapersRepository) {
        this.newspapersRepository = newspapersRepository;
    }

    @GetMapping(path = {"/getAll"})
    public Iterable<Newspapers> getAll() {
        return newspapersRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Newspapers getById(@PathVariable Long id){
        Optional<Newspapers> newspapers= newspapersRepository.findById(id);
        return newspapers.orElse(null);
    }

    @PostMapping(path={"/insert"})
    public void insert(@RequestBody Newspapers newspaper){
        newspapersRepository.save(newspaper);
    }

    @PutMapping(path={"/update/{id}"})
    public Newspapers update(@PathVariable("id") Long id,@RequestBody Newspapers newspaper){
        if(newspapersRepository.findById(id).isPresent())
            newspaper = newspapersRepository.save(newspaper);

        return newspaper;
    }

    @DeleteMapping(path={"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){
        if(newspapersRepository.findById(id).isPresent())
            newspapersRepository.deleteById(id);
    }

}
