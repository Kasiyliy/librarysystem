package com.sberteam.librarysustem.repositories;


import com.sberteam.librarysustem.models.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface OrdersRepository extends CrudRepository<Orders,Long> {

    @Query("select a from Orders a where a.date >= :from and :to <= a.date")
    List<Orders> queryFromTo(@Param("from")Date from, @Param("to")Date to);
}
