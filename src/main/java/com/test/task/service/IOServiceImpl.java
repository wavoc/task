package com.test.task.service;

import com.test.task.dao.IODao;
import com.test.task.dto.OrderDTO;
import com.test.task.dto.PaymentDTO;
import com.test.task.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IOServiceImpl implements IOService {
    private final IODao ioDao;

    public List<Category> getCategories() {
        return ioDao.getCategories();
    }

    public Optional<Category> getCategoryById(Integer id) {
        return ioDao.getCategoryById(id);
    }

    public List<Product> getProductList() {
        return ioDao.getProductList();
    }

    public Optional<Product> getProductById(Integer id) {
        return ioDao.getProductById(id);
    }

    public Optional<Order> getOrderDetailsById(Integer id) {
        return ioDao.getOrderDetailsById(id);
    }

    public Optional<Payment> getPaymentDetailsById(Integer id) {
        return ioDao.getPaymentDetailsById(id);
    }

    @Override
    public Map<String, Object> makeOrder(OrderDTO dto) {
        Date date = Date.valueOf(LocalDate.now());
        Date due = Date.valueOf(LocalDate.now().plusDays(7));
        Order order = new Order();
        Detail detail = new Detail();
        Invoice invoice = new Invoice();
        Optional<Product> product = ioDao.getProductById(dto.getProduct_id());
        invoice.setIssued(date);
        product.ifPresent(value -> invoice.setAmount(value.getPrice() * dto.getQuantity()));
        order.setDate(date);
        order.setCust_id(dto.getCustomer_id());
        Order savedOrder = ioDao.saveOrder(order);
        detail.setOrd_id(savedOrder.getId());
        detail.setQuantity(dto.getQuantity());
        detail.setPr_id(dto.getProduct_id());
        invoice.setOrd_id(savedOrder.getId());
        invoice.setDue(due);
        ioDao.saveDetail(detail);
        Invoice savedInvoice = ioDao.saveInvoice(invoice);
        Map<String, Object> map = new HashMap<>();
        if (savedInvoice.getId() != 0) {
            map.put("status", "SUCCESS");
            map.put("invoice_number", String.valueOf(savedInvoice.getId()));
        } else {
            map.put("status", "FAILED");
        }
        return map;
    }

    @Override
    public Map<String, Object> makePayment(PaymentDTO dto) {
        Map<String, Object> map = new HashMap<>();
        Payment payment = new Payment();
        Optional<Invoice> inv = ioDao.findInvoice(dto.getInvoice_id());
        if (inv.isPresent()) {
            payment.setAmount(inv.get().getAmount());
            payment.setInv_id(inv.get().getId());
            payment.setTime(Timestamp.valueOf(LocalDateTime.now()));
            Payment savedPayment = ioDao.savePayment(payment);
            map.put("Payment_status", "SUCCESS");
            map.put("Payment_details", savedPayment);
        } else {
            map.put("Payment_status", "FAILED");
        }
        return map;
    }

    @Override
    public Category addCategory(Category category) {
        return ioDao.addCategory(category);
    }

    @Override
    public Product addProduct(Product product) {
        return ioDao.addProduct(product);
    }

    @Override
    public Optional<Customer> getCustomerDetailsById(Integer customer_id) {
        Optional<Customer> customer = ioDao.getCustomerDetailsById(customer_id);
        if (customer.isPresent()) {
            return customer;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return ioDao.addCustomer(customer);
    }

    @Override
    public List<Customer> getCustomerList() {
        return ioDao.getCustomerList();
    }


}
