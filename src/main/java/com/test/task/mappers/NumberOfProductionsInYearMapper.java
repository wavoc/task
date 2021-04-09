package com.test.task.mappers;

import com.test.task.dto.NumberOfProductsInYear;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NumberOfProductionsInYearMapper implements RowMapper<NumberOfProductsInYear> {


    @Override
    public NumberOfProductsInYear mapRow(ResultSet resultSet, int i) throws SQLException {
        NumberOfProductsInYear n = new NumberOfProductsInYear();
        n.setCountry(resultSet.getString("country"));
        n.setTotal_number(resultSet.getInt("total_number"));
        return n;
    }
}
