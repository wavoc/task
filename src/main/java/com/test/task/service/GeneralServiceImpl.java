package com.test.task.service;

import com.test.task.dao.MainDao;
import com.test.task.dto.*;
import com.test.task.entity.Customer;
import com.test.task.entity.Invoice;
import com.test.task.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneralServiceImpl implements GeneralService {
    private final MainDao dao;

    public List<Invoice> expiredInvoices() {
        return dao.expiredInvoices();
    }

    public List<WrongDate> wrongDateInvoices() {
        return dao.wrongDateInvoices();
    }

    public List<Order> ordersWithoutDetails() {
        return dao.ordersWithoutDetails();
    }

    public List<Customer> customersWithoutOrders() {
        return dao.customersWithoutOrders();
    }

    public List<CustomersLastOrder> customersLastOrder() {
        return dao.customersLastOrder();
    }

    public List<OverpaidInvoices> overpaidInvoices() {
        return dao.overpaidInvoices();
    }

    public List<HighDemandProducts> highDemandProducts() {
        return dao.highDemandProducts();
    }

    public List<BulkProducts> bulkProducts() {
        return dao.bulkProducts();
    }

    public List<NumberOfProductsInYear> numberOfProductsInYear() {
        return dao.numberOfProductsInYear();
    }

    public List<OrdersWithoutInvoice> ordersWithoutInvoice() {
        return dao.ordersWithoutInvoice();
    }


}

