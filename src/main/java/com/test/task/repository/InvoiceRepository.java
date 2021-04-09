package com.test.task.repository;

import com.test.task.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = "select * from invoice i where i.due < i.issued", nativeQuery = true)
    List<Invoice> expiredInvoices();

    Optional<Invoice> findById(Integer id);
}
