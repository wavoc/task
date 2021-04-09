package com.test.task.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "cust_id")
    private int cust_id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ord_id")
    private Set<Detail> detail;

    @OneToOne(targetEntity = Invoice.class, fetch = FetchType.EAGER)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Invoice invoice;
}
