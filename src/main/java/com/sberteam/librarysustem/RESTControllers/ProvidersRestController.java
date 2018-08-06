package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.Providers;
import com.sberteam.librarysustem.repositories.ProvidersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "rest/providers/",produces = "application/json")
public class ProvidersRestController {
    ProvidersRepository providersRepository;

    public ProvidersRestController(ProvidersRepository providersRepository) {
        this.providersRepository = providersRepository;
    }

    @GetMapping("/getAll")
    public Iterable<Providers> getAll(){
        return providersRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Providers getById(@PathVariable  Long id){
        Optional<Providers> provider= providersRepository.findById(id);
        return provider.orElse(null);
    }

    @PostMapping(path={"/insert"})
    public void insert(@RequestBody Providers provider){
        providersRepository.save(provider);
    }

    @PutMapping(path={"/update/{id}"})
    public Providers update(@PathVariable("id") Long id,@RequestBody Providers provider){
        if(providersRepository.findById(id).isPresent())
            provider = providersRepository.save(provider);

        return provider;
    }

    @DeleteMapping(path={"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){
        if(providersRepository.findById(id).isPresent())
            providersRepository.deleteById(id);
    }
}
