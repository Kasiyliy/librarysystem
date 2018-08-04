package com.sberteam.librarysustem.RESTControllers;


import com.sberteam.librarysustem.models.BooksLevels;
import com.sberteam.librarysustem.repositories.BooksLevelsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/rest/books/levels",produces = "application/json")
public class BooksLevelsRestController {

    private BooksLevelsRepository booksLevelsRepository;

    public BooksLevelsRestController(BooksLevelsRepository booksLevelsRepository){
        this.booksLevelsRepository = booksLevelsRepository;
    }

    @GetMapping("/getAll")
    public Iterable<BooksLevels> getAll(){
        return booksLevelsRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public BooksLevels getById(@PathVariable Long id){
        Optional<BooksLevels> booksCategory= booksLevelsRepository.findById(id);
        return booksCategory.orElse(null);
    }

    @PostMapping(path={"/insert"})
    public void insert(@RequestBody BooksLevels booksLevel){
        booksLevelsRepository.save(booksLevel);
    }

    @PutMapping(path={"/update/{id}"})
    public BooksLevels update(@PathVariable("id") Long id,@RequestBody BooksLevels booksLevel){
        if(booksLevelsRepository.findById(id).isPresent())
            booksLevel = booksLevelsRepository.save(booksLevel);

        return booksLevel;
    }

    @DeleteMapping(path={"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){
        if(booksLevelsRepository.findById(id).isPresent())
            booksLevelsRepository.deleteById(id);
    }

}
