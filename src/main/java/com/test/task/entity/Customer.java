package com.test.task.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "customer")
@RequiredArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 14)
    private String name;

    @Column(name = "country", length = 3)
    private String country;

    @Column(name = "address")
    private String address;

    @Column(name = "phone", length = 50)
    private String phone;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "cust_id")
    private Set<Order> order;
}
