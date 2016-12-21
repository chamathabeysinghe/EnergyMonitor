package com.ceb.database;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceb.models.ConnectionRequest;

public class ConnectionRequestDAO {
	
	public static void saveConnectionRequest(ConnectionRequest connectionRequest) {
		
		System.out.println(connectionRequest.getNewConnectionDetails());
		
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.now();
	    String date = dtf.format(localDate);
	    
		String sql = "INSERT INTO newconnectionrequest (date, status, newConnectionDetails, customerID)"
                + " VALUES (?, ?, ?, ?)";
		DataAccess.getInstance().update(sql, date, "pending", connectionRequest.getNewConnectionDetails(), 1); 
	
	}
	
	public static int getId() {
		String sql = "SELECT MAX(ID) FROM newconnectionrequest";
		return DataAccess.getInstance().queryForInt(sql);
	}
}