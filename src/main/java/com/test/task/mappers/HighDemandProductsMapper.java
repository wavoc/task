package com.test.task.mappers;

import com.test.task.dto.HighDemandProducts;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HighDemandProductsMapper implements RowMapper<HighDemandProducts> {


    @Override
    public HighDemandProducts mapRow(ResultSet resultSet, int i) throws SQLException {
        HighDemandProducts h = new HighDemandProducts();
        h.setProduct_code(resultSet.getInt("product_code"));
        h.setTotal_amount(resultSet.getInt("total_amount"));
        return h;
    }
}
