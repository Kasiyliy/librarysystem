package com.sberteam.librarysustem.RESTControllers;


import com.sberteam.librarysustem.models.BooksCategories;
import com.sberteam.librarysustem.models.Parties;
import com.sberteam.librarysustem.repositories.BooksCategoriesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("rest/books/categories")
public class BooksCategoriesRestController {
    private BooksCategoriesRepository booksCategoriesRepository;


    public BooksCategoriesRestController(BooksCategoriesRepository booksCategoriesRepository){
        this.booksCategoriesRepository = booksCategoriesRepository;
    }

    @GetMapping("/getAll")
    public Iterable<BooksCategories> getAll(){
        return booksCategoriesRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public BooksCategories getById(@PathVariable  Long id){
        Optional<BooksCategories> booksCategory= booksCategoriesRepository.findById(id);
        return booksCategory.orElse(null);
    }

    @PostMapping(path={"/insert"})
    public void insert(@RequestBody BooksCategories booksCategory){
        booksCategoriesRepository.save(booksCategory);
    }

    @PutMapping(path={"/update/{id}"})
    public BooksCategories update(@PathVariable("id") Long id,@RequestBody BooksCategories booksCategory){
        if(booksCategoriesRepository.findById(id).isPresent())
            booksCategory = booksCategoriesRepository.save(booksCategory);

        return booksCategory;
    }

    @DeleteMapping(path={"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){
        if(booksCategoriesRepository.findById(id).isPresent())
            booksCategoriesRepository.deleteById(id);
    }
}
