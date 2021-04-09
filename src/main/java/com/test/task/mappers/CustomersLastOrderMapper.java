package com.test.task.mappers;

import com.test.task.dto.CustomersLastOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersLastOrderMapper implements RowMapper<CustomersLastOrder> {

    @Override
    public CustomersLastOrder mapRow(ResultSet resultSet, int i) throws SQLException {

        CustomersLastOrder c = new CustomersLastOrder();
        c.setId(resultSet.getInt("id"));
        c.setName(resultSet.getString("name"));
        c.setDate(resultSet.getDate("date"));
        return c;
    }
}
