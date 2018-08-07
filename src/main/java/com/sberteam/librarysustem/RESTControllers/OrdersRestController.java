package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.Books;
import com.sberteam.librarysustem.models.Orders;
import com.sberteam.librarysustem.repositories.BooksRepository;
import com.sberteam.librarysustem.repositories.OrdersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/orders",produces = "application/json")
public class OrdersRestController {
    private OrdersRepository ordersRepository;

    public OrdersRestController(OrdersRepository ordersRepository) {

        this.ordersRepository = ordersRepository;
    }

    @GetMapping(path = {"/getAll"})
    public Iterable<Orders> getAll() {

        return ordersRepository.findAll();
    }
}

