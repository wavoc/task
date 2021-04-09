package com.test.task.service;

import com.test.task.dto.*;
import com.test.task.entity.Customer;
import com.test.task.entity.Invoice;
import com.test.task.entity.Order;

import java.util.List;

public interface GeneralService {

    List<Invoice> expiredInvoices();

    List<WrongDate> wrongDateInvoices();

    List<Order> ordersWithoutDetails();

    List<Customer> customersWithoutOrders();

    List<CustomersLastOrder> customersLastOrder();

    List<OverpaidInvoices> overpaidInvoices();

    List<HighDemandProducts> highDemandProducts();

    List<BulkProducts> bulkProducts();

    List<NumberOfProductsInYear> numberOfProductsInYear();

    List<OrdersWithoutInvoice> ordersWithoutInvoice();

}
