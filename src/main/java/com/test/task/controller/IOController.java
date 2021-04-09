package com.test.task.controller;

import com.test.task.dto.OrderDTO;
import com.test.task.dto.PaymentDTO;
import com.test.task.entity.Category;
import com.test.task.entity.Customer;
import com.test.task.entity.Product;
import com.test.task.service.IOService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class IOController {
    private final IOService ioService;

    @GetMapping(value = "category/list")
    public ResponseEntity<?> getCategoryList() {
        return ResponseEntity.ok(ioService.getCategories());
    }

    @GetMapping(value = "category/details")
    public ResponseEntity<?> getCategoryById(@RequestParam(name = "product_id") Integer product_id) {
        return ResponseEntity.ok(ioService.getCategoryById(product_id));
    }

    @GetMapping(value = "product/list")
    public ResponseEntity<?> getProductList() {
        return ResponseEntity.ok(ioService.getProductList());
    }

    @GetMapping(value = "product/details")
    public ResponseEntity<?> getProductById(@RequestParam(name = "product_id") Integer product_id) {
        return ResponseEntity.ok(ioService.getProductById(product_id));
    }

    @PostMapping(value = "/order")
    public ResponseEntity<?> makeOrder(@RequestBody OrderDTO dto) {
        return ResponseEntity.ok(ioService.makeOrder(dto));
    }

    @GetMapping(value = "/order/details")
    public ResponseEntity<?> getOrderDetailsById(@RequestParam(name = "order_id") Integer order_id) {
        return ResponseEntity.ok(ioService.getOrderDetailsById(order_id));
    }

    @PostMapping(value = "/payment")
    public ResponseEntity<?> makePayment(@RequestBody PaymentDTO dto) {
        return ResponseEntity.ok(ioService.makePayment(dto));
    }

    @GetMapping(value = "/payment/details")
    public ResponseEntity<?> getPaymentDetailsById(@RequestParam(name = "payment_details_id") Integer payment_details_id) {
        return ResponseEntity.ok(ioService.getPaymentDetailsById(payment_details_id));
    }

    @PostMapping(value = "/customer/add")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(ioService.addCustomer(customer));
    }

    @GetMapping(value = "/customer/details")
    public ResponseEntity<?> getCustomerDetailsById(@RequestParam(name = "customer_id") Integer customer_id) {
        return ResponseEntity.ok(ioService.getCustomerDetailsById(customer_id));
    }

    @GetMapping(value = "/customer/list")
    public ResponseEntity<?> getCustomerList() {
        return ResponseEntity.ok(ioService.getCustomerList());
    }

    @PostMapping(value = "/category/add")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(ioService.addCategory(category));
    }

    @PostMapping(value = "/product/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(ioService.addProduct(product));
    }

}
