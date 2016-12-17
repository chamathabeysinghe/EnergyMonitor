package com.ceb.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ceb.models.User;

public class UserRowMapper implements RowMapper<User>{
	
	public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u =new User();
		b.setConnectionID(rs.getInt("connectionID"));
		b.setAmount(rs.getDouble("amount"));
		b.setMonth(rs.getString("month"));
		b.setUsage(rs.getDouble("usage"));
		b.setYear(rs.getInt("year"));
		return b;
	}
}