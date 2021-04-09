package com.test.task.dao;

import com.test.task.dto.*;
import com.test.task.entity.Customer;
import com.test.task.entity.Invoice;
import com.test.task.entity.Order;
import com.test.task.repository.CustomerRepository;
import com.test.task.repository.InvoiceRepository;
import com.test.task.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDao {
    private final JdbcTemplate jdbcTemplate;
    private final CustomerRepository customerRepository;
    private final InvoiceRepository invoiceRepository;
    private final OrderRepository orderRepository;

    private final String customersLastOrder = "select foo.cust_id as id, c.name as name,  foo.date as date from customer c left join (select cust_id, date from (select o.*,row_number() over (partition by o.cust_id order by o.date desc) as rn from orders o) t where rn = 1 order by cust_id) as foo on c.id = foo.cust_id where foo.date is not null";
    private final String numberOfProductsInYear = "select c.country, sum(o.id) as total_number from customer c left join orders o on c.id = o.cust_id where o.date >= '2015-12-31' and o.date <= '2017-01-01' group by c.country having count(o.id) >= 1";
    private final String bulkProducts = "select p.id as product_code, p.price from product p inner join detail d on p.id = d.pr_id where d.quantity >= 8";
    private final String wrongDateInvoices = "select i.id as invoice_id, i.issued as issued_date, o.id as order_id, o.date as order_date from orders o full outer join invoice i on o.id = i.ord_id where o.date > i.issued";
    private final String highDemandProducts = "select d.pr_id as product_code, sum(d.quantity) as total_amount from orders o inner join detail d on o.id = d.ord_id where d.quantity > 10 group by d.pr_id";
    private final String ordersWithoutInvoice = "select t.* from (select o.id as order_id, o.date as order_date, (d.quantity * p.price) as total_price from orders o full outer join detail d on o.id = d.ord_id full outer join product p on d.pr_id = p.id where d.ord_id is not null) as t full outer join invoice i on t.order_id = i.ord_id where i.ord_id is null";
    private final String overpaidInvoices = "select invoice_id, sum(payment_invoice_id) as amount from (select i.id as invoice_id, p.inv_id as payment_invoice_id from invoice i left join payment p on i.id = p.inv_id) t group by t.invoice_id having count(payment_invoice_id) > 1";

    public List<Invoice> expiredInvoices() {
        return invoiceRepository.expiredInvoices();
    }

    public List<WrongDate> wrongDateInvoices() {
        return jdbcTemplate.query(wrongDateInvoices, new BeanPropertyRowMapper<>(WrongDate.class));
    }

    public List<Order> ordersWithoutDetails() {
        return orderRepository.ordersWithoutDetails();
    }

    public List<Customer> customersWithoutOrders() {
        return customerRepository.customersWithoutOrders();
    }

    public List<CustomersLastOrder> customersLastOrder() {
        return jdbcTemplate.query(customersLastOrder, new BeanPropertyRowMapper<>(CustomersLastOrder.class));
    }

    public List<OverpaidInvoices> overpaidInvoices() {
        return jdbcTemplate.query(overpaidInvoices, new BeanPropertyRowMapper<>(OverpaidInvoices.class));
    }

    public List<HighDemandProducts> highDemandProducts() {
        return jdbcTemplate.query(highDemandProducts, new BeanPropertyRowMapper<>(HighDemandProducts.class));
    }

    public List<BulkProducts> bulkProducts() {
        return jdbcTemplate.query(bulkProducts, new BeanPropertyRowMapper<>(BulkProducts.class));
    }

    public List<NumberOfProductsInYear> numberOfProductsInYear() {
        return jdbcTemplate.query(numberOfProductsInYear, new BeanPropertyRowMapper<>(NumberOfProductsInYear.class));
    }

    public List<OrdersWithoutInvoice> ordersWithoutInvoice() {
        return jdbcTemplate.query(ordersWithoutInvoice, new BeanPropertyRowMapper<>(OrdersWithoutInvoice.class));
    }


}
