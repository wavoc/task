package com.test.task.mappers;

import com.test.task.dto.BulkProducts;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BulkProductsMapper implements RowMapper<BulkProducts> {

    @Override
    public BulkProducts mapRow(ResultSet resultSet, int i) throws SQLException {

        BulkProducts p = new BulkProducts();
        p.setProduct_code(resultSet.getInt("product_code"));
        p.setPrice(resultSet.getDouble("price"));
        return p;
    }
}
