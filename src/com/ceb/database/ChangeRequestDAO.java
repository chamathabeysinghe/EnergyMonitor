package com.ceb.database;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.ceb.models.ChangeRequest;
import com.mysql.cj.api.jdbc.Statement;

public class ChangeRequestDAO {
	
	public static void saveNewChangeRequest(ChangeRequest changeRequest) {
		
		System.out.println(changeRequest.getChangeDetails());
		
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.now();
	    String date = dtf.format(localDate);
	    
		String sql = "INSERT INTO changerequest (date, status, changeDetails, connectionID)"
                + " VALUES (?, ?, ?, ?)";
		DataAccess.getInstance().update(sql, date, "pending", changeRequest.getChangeDetails(), 1); 
	
	}
	
	public static int getId() {
		String sql = "SELECT MAX(ID) FROM changerequest";
		return DataAccess.getInstance().queryForInt(sql);
	}
	
	public static List<ChangeRequest> getAllChangeRequests() {
		String sql = "SELECT * FROM changerequest";
		List<ChangeRequest> changerequests  = DataAccess.getInstance().query(sql, new BeanPropertyRowMapper<ChangeRequest>(ChangeRequest.class));
		return changerequests;
		
	}
}