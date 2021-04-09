package com.test.task.repository;

import com.test.task.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select id, name, country, address, phone\n" +
            "from (select c.id, c.name, c.country, c.address, c.phone, o.date\n" +
            "      from customer c\n" +
            "               left join orders o on c.id = o.cust_id) as t\n" +
            "where (t.date > '2015-12-31' and t.date < '2017-01-01') is null", nativeQuery = true)
    List<Customer> customersWithoutOrders();

    List<Customer> findAll();


}
