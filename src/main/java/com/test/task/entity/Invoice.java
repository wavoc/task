package com.test.task.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "invoice")
@RequiredArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ord_id")
    private int ord_id;

    @Column(name = "amount", precision = 8, scale = 2, nullable = false)
    private double amount;

    @Column(name = "issued", nullable = false)
    private Date issued;

    @Column(name = "due", nullable = false)
    private Date due;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "inv_id")
    private Set<Payment> payment;
}
