package com.test.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HighDemandProducts {
    private Integer product_code;
    private Integer total_amount;
}
