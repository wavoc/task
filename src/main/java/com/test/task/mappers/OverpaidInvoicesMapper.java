package com.test.task.mappers;

import com.test.task.dto.OverpaidInvoices;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OverpaidInvoicesMapper implements RowMapper<OverpaidInvoices> {

    @Override
    public OverpaidInvoices mapRow(ResultSet resultSet, int i) throws SQLException {
        OverpaidInvoices o = new OverpaidInvoices();
        o.setInvoice_id(resultSet.getInt("invoice_id"));
        o.setAmount(resultSet.getDouble("amount"));
        return o;
    }
}
