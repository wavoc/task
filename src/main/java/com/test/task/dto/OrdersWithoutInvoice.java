package com.test.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersWithoutInvoice {
    private Integer order_id;
    private Date order_date;
    private Double total_price;
}
