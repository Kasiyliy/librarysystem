package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.*;
import com.sberteam.librarysustem.repositories.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/rest/books",produces = "application/json")
public class BooksRestController {

    private BooksRepository booksRepository;
    private PartiesRepository partiesRepository;
    private BooksCategoriesRepository booksCategoriesRepository;
    private BooksLevelsRepository booksLevelsRepository;
    private BooksMapsRepository booksMapsRepository;

    public BooksRestController(BooksRepository booksRepository, PartiesRepository partiesRepository, BooksCategoriesRepository booksCategoriesRepository,
                               BooksLevelsRepository booksLevelsRepository, BooksMapsRepository booksMapsRepository) {
        this.booksRepository = booksRepository;
        this.partiesRepository = partiesRepository;
        this.booksCategoriesRepository = booksCategoriesRepository;
        this.booksLevelsRepository = booksLevelsRepository;
        this.booksMapsRepository = booksMapsRepository;
    }

    @GetMapping(path = {"/getAllBooks"})
    public Iterable<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    @GetMapping(path = {"/getAllBooksCategories"})
    public Iterable<BooksCategories> getAllBooksCategories(){
        return booksCategoriesRepository.findAll();
    }

    @GetMapping(path = {"/getAllBooksMaps"})
    public Iterable<BooksMaps> getAllBooksMaps(){
        return booksMapsRepository.findAll();
    }

    @GetMapping(path = {"/getAllBooksLevels"})
    public Iterable<BooksLevels> getAllBooksLevels(){
        return booksLevelsRepository.findAll();
    }

    @PostMapping(path={"/insert"})
    public void insertBook(@RequestBody Books book){
        booksRepository.save(book);
    }

    @PutMapping(path={"/update/{id}"})
    public Books updateBook(@PathVariable("id") Long id,@RequestBody Books book){
        System.out.println(book.getName());
        if(booksRepository.findById(id).isPresent())
            book = booksRepository.save(book);

        return book;
    }

    @DeleteMapping(path={"/delete/{id}"})
    public void deleteBook(@PathVariable("id") Long id){
        if(booksRepository.findById(id).isPresent())
            booksRepository.deleteById(id);
    }

}
