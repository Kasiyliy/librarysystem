package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.Books;
import com.sberteam.librarysustem.repositories.BooksRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/rest/books",produces = "application/json")
public class BooksRestController {

    private BooksRepository booksRepository;

    public BooksRestController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @GetMapping(path = {"/getAll"})
    public Iterable<Books> getAll() {
        return booksRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Books getById(@RequestParam Long id){
        Optional<Books> books= booksRepository.findById(id);
        return books.orElse(null);
    }

    @PostMapping(path={"/insert"})
    public void insert(@RequestBody Books book){
        book.setSum(book.getCount()*book.getPrice());
        booksRepository.save(book);
    }

    @PutMapping(path={"/update/{id}"})
    public Books update(@PathVariable("id") Long id,@RequestBody Books book){
        if(booksRepository.findById(id).isPresent())
            book = booksRepository.save(book);

        return book;
    }

    @DeleteMapping(path={"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){
        if(booksRepository.findById(id).isPresent())
            booksRepository.deleteById(id);
    }

}
