package com.test.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WrongDate {

    private Integer invoice_id;
    private Date issued_date;
    private Integer order_id;
    private Date order_date;
}
