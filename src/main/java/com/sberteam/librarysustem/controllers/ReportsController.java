package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.models.BasicUsers;
import com.sberteam.librarysustem.repositories.BasicUsersRepository;
import org.jxls.template.SimpleExporter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/reports")
public class ReportsController {
    BasicUsersRepository basicUsersRepository;

    public ReportsController(BasicUsersRepository basicUsersRepository){
        this.basicUsersRepository = basicUsersRepository;
    }

    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {
        ModelAndView mw = new ModelAndView("/reports/index");
        mw.addObject("books", basicUsersRepository.findAll());
        return mw;
    }
    @PostMapping(path = "/exportExcel")
    public void export(HttpServletResponse response){
        List<BasicUsers> users = (List<BasicUsers>) basicUsersRepository.findAll();
        List<String> headers = Arrays.asList("ID","Имя","Фамилия","Patronomyc");
        try{
            response.addHeader("Content-Disposition", "attachment; filename = BasicUsers.xls");
            response.setContentType("application/vnd.ms-excel");
            new SimpleExporter().gridExport(headers,users,"id, name, surname, patronomyc, ",response.getOutputStream());
            response.flushBuffer();
        }catch (Exception e){
            e.getMessage();
        }
    }
}
