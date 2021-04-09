package com.test.task.service;

import com.test.task.dto.OrderDTO;
import com.test.task.dto.PaymentDTO;
import com.test.task.entity.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IOService {
    List<Category> getCategories();

    Optional<Category> getCategoryById(Integer id);

    List<Product> getProductList();

    Optional<Product> getProductById(Integer id);

    Optional<Order> getOrderDetailsById(Integer id);

    Optional<Payment> getPaymentDetailsById(Integer id);

    Map<String, Object> makePayment(PaymentDTO dto);

    Map<String, Object> makeOrder(OrderDTO dto);

    Category addCategory(Category category);

    Product addProduct(Product product);

    Optional<Customer> getCustomerDetailsById(Integer customer_id);

    Customer addCustomer(Customer customer);

    List<Customer> getCustomerList();
}
