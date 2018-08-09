package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.models.BasicUsers;
import com.sberteam.librarysustem.models.Books;
import com.sberteam.librarysustem.repositories.*;
import org.jxls.template.SimpleExporter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/reports")
public class ReportsController {
    BasicUsersRepository basicUsersRepository;
    BooksRepository booksRepository;
    BooksCategoriesRepository booksCategoriesRepository;
    LanguagesRepository languagesRepository;
    BooksLevelsRepository booksLevelsRepository;
    BooksMapsRepository booksMapsRepository;
    PartiesRepository partiesRepository;

    public ReportsController(BasicUsersRepository basicUsersRepository, BooksRepository booksRepository, BooksCategoriesRepository booksCategoriesRepository, LanguagesRepository languagesRepository, BooksLevelsRepository booksLevelsRepository, BooksMapsRepository booksMapsRepository, PartiesRepository partiesRepository) {
        this.basicUsersRepository = basicUsersRepository;
        this.booksRepository = booksRepository;
        this.booksCategoriesRepository = booksCategoriesRepository;
        this.languagesRepository = languagesRepository;
        this.booksLevelsRepository = booksLevelsRepository;
        this.booksMapsRepository = booksMapsRepository;
        this.partiesRepository = partiesRepository;
    }

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {
        ModelAndView mw = new ModelAndView("/reports/index");
        mw.addObject("users", basicUsersRepository.findAll());
        return mw;
    }

    @PostMapping(path = "/exportExcel")
    public void export(HttpServletResponse response, HttpServletRequest request){

        String section = request.getParameter("section");

        try{
            if(section.equals("users")) {
                List<BasicUsers> users = (List<BasicUsers>) basicUsersRepository.findAll();
                List<String> headers = Arrays.asList("ID", "Имя", "Фамилия", "Patronomyc");
                response.addHeader("Content-Disposition", "attachment; filename = BasicUsers.xls");
                response.setContentType("application/vnd.ms-excel");
                new SimpleExporter().gridExport(headers, users, "id, name, surname, patronomyc, ", response.getOutputStream());
            }else if (section.equals("books")){
                String from = request.getParameter("from");
                String to = request.getParameter("to");
                String language = request.getParameter("language");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                Date fromd = formatter.parse(from);
                Date tod = formatter.parse(to);
                List<Books> books = (List<Books>) booksRepository.queryFromTo(new java.sql.Date(fromd.getTime()),new java.sql.Date(tod.getTime()),Long.parseLong(language));
                List<String> headers = Arrays.asList("ID", "Автор", "Имя", "Цена" , "Место издательство", "Издательство", "Номер тома", "Номер перевода", "Год", "Категория", "Язык", "Уровень", "Карта", "Партия", "Количество");
                response.addHeader("Content-Disposition", "attachment; filename = Books.xls");
                response.setContentType("application/vnd.ms-excel");
                new SimpleExporter().gridExport(headers, books, "id, author, name, count,publicationPlace,publisher,tom_number,transferNumber, year, bookCategory.name, language.name, level.name, map.name, party.partyNum, count", response.getOutputStream());
            }
            response.flushBuffer();
        }catch (Exception e){
            e.getMessage();
        }
    }
}
