package com.test.task.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "category_id")
    private int category_id;

    @Column(name = "description", length = 20)
    private String description;

    @Column(name = "price", precision = 8, scale = 2)
    private double price;

    @Column(name = "photo", length = 1024)
    private String photo;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pr_id")
    private Set<Detail> detail;
}
