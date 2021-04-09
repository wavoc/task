package com.test.task.mappers;

import com.test.task.dto.OrdersWithoutInvoice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderWithoutInvoiceMapper implements RowMapper<OrdersWithoutInvoice> {

    @Override
    public OrdersWithoutInvoice mapRow(ResultSet resultSet, int i) throws SQLException {
        OrdersWithoutInvoice o = new OrdersWithoutInvoice();
        o.setOrder_id(resultSet.getInt("order_id"));
        o.setOrder_date(resultSet.getDate("order_date"));
        o.setTotal_price(resultSet.getDouble("total_price"));
        return o;
    }
}
