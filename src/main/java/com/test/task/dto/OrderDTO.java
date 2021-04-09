package com.test.task.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrderDTO {
    private Integer customer_id;
    private Integer product_id;
    private Short quantity;
}
