package com.test.task.mappers;

import com.test.task.dto.WrongDate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WrongDateMapper implements RowMapper<WrongDate> {


    @Override
    public WrongDate mapRow(ResultSet resultSet, int i) throws SQLException {

        WrongDate w = new WrongDate();
        w.setInvoice_id(resultSet.getInt("invoice_id"));
        w.setIssued_date(resultSet.getDate("issued_date"));
        w.setOrder_id(resultSet.getInt("order_id"));
        w.setOrder_date(resultSet.getDate("order_date"));
        return w;
    }
}
