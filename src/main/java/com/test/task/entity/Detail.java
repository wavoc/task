package com.test.task.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detail")
@RequiredArgsConstructor
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ord_id")
    private int ord_id;

    @Column(name = "pr_id")
    private int pr_id;

    @Column(name = "quantity", nullable = false)
    private short quantity;
}
