package com.test.task.controller;

import com.test.task.service.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GeneralRequestsController {
    private final GeneralService service;

    @GetMapping(value = "/expired_invoices")
    public ResponseEntity<?> expiredInvoices() {
        return ResponseEntity.ok(service.expiredInvoices());
    }

    @GetMapping(value = "/wrong_date_invoices")
    public ResponseEntity<?> wrongDateInvoices() {
        return ResponseEntity.ok(service.wrongDateInvoices());
    }

    @GetMapping(value = "/orders_without_details")
    public ResponseEntity<?> ordersWithoutDetails() {
        return ResponseEntity.ok(service.ordersWithoutDetails());
    }

    @GetMapping(value = "/customers_without_orders")
    public ResponseEntity<?> customersWithoutOrders() {
        return ResponseEntity.ok(service.customersWithoutOrders());
    }

    @GetMapping(value = "/customers_last_orders")
    public ResponseEntity<?> customersLastOrders() {
        return ResponseEntity.ok(service.customersLastOrder());
    }

    @GetMapping(value = "/overpaid_invoices")
    public ResponseEntity<?> overpaidInvoices() {
        return ResponseEntity.ok(service.overpaidInvoices());
    }

    @GetMapping(value = "/high_demand_products")
    public ResponseEntity<?> highDemandProducts() {
        return ResponseEntity.ok(service.highDemandProducts());
    }

    @GetMapping(value = "/bulk_products")
    public ResponseEntity<?> bulkProducts() {
        return ResponseEntity.ok(service.bulkProducts());
    }

    @GetMapping(value = "/number_of_products_in_year")
    public ResponseEntity<?> numberOfProductsInYear() {
        return ResponseEntity.ok(service.numberOfProductsInYear());
    }

    @GetMapping(value = "/orders_without_invoices")
    public ResponseEntity<?> ordersWithoutInvoices() {
        return ResponseEntity.ok(service.ordersWithoutInvoice());
    }
}
