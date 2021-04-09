package com.test.task.repository;

import com.test.task.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "select foo.id as id, date as date, cust_id as cust_id, foo.ordd as ord_id\n" +
            "from (select o.id, o.date, o.cust_id, o.ord_id as ordd, d.ord_id\n" +
            "      from orders o\n" +
            "               left join detail d on o.id = d.ord_id\n" +
            "      where d.ord_id is null\n" +
            "        and o.date < '2016-09-06') as foo", nativeQuery = true)
    List<Order> ordersWithoutDetails();

    Optional<Order> findById(Integer id);

}
