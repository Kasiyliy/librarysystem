package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.BooksMaps;
import com.sberteam.librarysustem.repositories.BooksMapsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/rest/books/maps",produces = "application/json")
public class BooksMapsRestController {
    private BooksMapsRepository booksMapsRepository;

    public BooksMapsRestController(BooksMapsRepository booksMapsRepository){
        this.booksMapsRepository = booksMapsRepository;
    }

    @GetMapping("/getAll")
    public Iterable<BooksMaps> getAll(){
        return booksMapsRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public BooksMaps getById(@PathVariable  Long id){
        Optional<BooksMaps> booksCategory= booksMapsRepository.findById(id);
        return booksCategory.orElse(null);
    }

    @PostMapping(path={"/insert"})
    public void insert(@RequestBody BooksMaps booksMap){
        booksMapsRepository.save(booksMap);
    }

    @PutMapping(path={"/update/{id}"})
    public BooksMaps update(@PathVariable("id") Long id,@RequestBody BooksMaps booksMap){
        if(booksMapsRepository.findById(id).isPresent())
            booksMap = booksMapsRepository.save(booksMap);

        return booksMap;
    }

    @DeleteMapping(path={"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){
        if(booksMapsRepository.findById(id).isPresent())
            booksMapsRepository.deleteById(id);
    }
}
