package com.test.task.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "payment")
@RequiredArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "time", nullable = false)
    @CreationTimestamp
    private Timestamp time;

    @Column(name = "amount", precision = 8, scale = 2, nullable = false)
    private double amount;

    @Column(name = "inv_id")
    private int inv_id;

}
