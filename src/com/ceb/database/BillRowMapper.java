package com.ceb.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ceb.models.Bill;

public class BillRowMapper implements RowMapper<Bill>{
	
	public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bill b=new Bill();
		b.setConnectionID(rs.getInt("connectionID"));
		b.setAmount(rs.getDouble("amount"));
		b.setMonth(rs.getString("month"));
		b.setUsage(rs.getDouble("usage"));
		return b;
	}
}