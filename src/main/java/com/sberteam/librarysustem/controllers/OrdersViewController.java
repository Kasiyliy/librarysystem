package com.sberteam.librarysustem.controllers;

import com.sberteam.librarysustem.models.BasicUsers;
import com.sberteam.librarysustem.models.Orders;
import com.sberteam.librarysustem.repositories.BasicUsersRepository;
import com.sberteam.librarysustem.repositories.BooksRepository;
import com.sberteam.librarysustem.repositories.OrdersRepository;
import org.jxls.template.SimpleExporter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class OrdersViewController {
    OrdersRepository ordersRepository;

    public OrdersViewController(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }
    @GetMapping(path = {"/" , ""})
    public ModelAndView index() {
        ModelAndView mw = new ModelAndView("orders/view");
        return mw;
    }
    @GetMapping(path = {"/statreport"})
    public ModelAndView statReport() {
        ModelAndView mw = new ModelAndView("orders/statreport");
        return mw;
    }
    @PostMapping(path = "/statreportexcel")
    public void export(HttpServletResponse response, HttpServletRequest request) throws ParseException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date fromd = formatter.parse(from);
        Date tod = formatter.parse(to);
        List<Orders> orders = (List<Orders>) ordersRepository.queryFromTo(new java.sql.Date(fromd.getTime()),new java.sql.Date(tod.getTime()));
        List<String> headers = Arrays.asList("ID","Автор","Штрих-Код","Пользователь");
        try{
            response.addHeader("Content-Disposition", "attachment; filename = StatReport.xls");
            response.setContentType("application/vnd.ms-excel");
            new SimpleExporter().gridExport(headers,orders,"id, author, barcode, reader, ",response.getOutputStream());
            response.flushBuffer();
        }catch (Exception e){
            e.getMessage();
        }
    }
}
