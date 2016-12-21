package com.ceb.database;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.ceb.models.Complaint;
import com.ceb.models.ConnectionRequest;

public class ConnectionRequestDAO {
	
	public static void saveConnectionRequest(ConnectionRequest connectionRequest,int userID) {
		
		System.out.println(connectionRequest.getNewConnectionDetails());
		
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.now();
	    String date = dtf.format(localDate);
	    
		String sql = "INSERT INTO newconnectionrequest (date, status, newConnectionDetails, customerID)"
                + " VALUES (?, ?, ?, ?)";
		DataAccess.getInstance().update(sql, date, "pending", connectionRequest.getNewConnectionDetails(), userID); 
	
	}
	
	public static int getId() {
		String sql = "SELECT MAX(ID) FROM newconnectionrequest";
		return DataAccess.getInstance().queryForInt(sql);
	}
	
	public static List<ConnectionRequest> getAllConnectionRequests() {
		String sql = "SELECT * FROM newconnectionrequest";
		List<ConnectionRequest> connectionRequests  = DataAccess.getInstance().query(sql, new BeanPropertyRowMapper<ConnectionRequest>(ConnectionRequest.class));
		return connectionRequests;
		
	}
	
}