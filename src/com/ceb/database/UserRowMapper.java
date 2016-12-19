package com.ceb.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ceb.models.User;

public class UserRowMapper implements RowMapper<User>{
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u =new User();
		
		u.setFirstName(rs.getString("firstName"));
		u.setLastName(rs.getString("lastName"));
		u.setAddress(rs.getString("address"));
		u.setNameWithInitials(rs.getString("nameWithInitials"));
		u.setNIC(rs.getString("NIC"));
		u.setAddress(rs.getString("address"));
		u.setPhoneNumber(rs.getString("phoneNumber"));
		u.setEmail(rs.getString("email"));
		u.setPassword(rs.getString("password"));
		
		return u;
	}
}