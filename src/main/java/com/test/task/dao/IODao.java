package com.test.task.dao;

import com.test.task.entity.*;
import com.test.task.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class IODao {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final DetailRepository detailRepository;
    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public Optional<Order> getOrderDetailsById(Integer id) {
        return orderRepository.findById(id);
    }

    public Optional<Payment> getPaymentDetailsById(Integer id) {
        return paymentRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void saveDetail(Detail detail) {
        detailRepository.save(detail);
    }

    public Optional<Invoice> findInvoice(Integer id) {
        return invoiceRepository.findById(id);
    }

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Customer> getCustomerDetailsById(Integer customer_id) {
        return customerRepository.findById(customer_id);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }
}
