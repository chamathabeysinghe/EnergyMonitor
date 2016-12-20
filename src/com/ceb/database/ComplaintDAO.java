package com.ceb.database;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceb.models.Complaint;

public class ComplaintDAO {
	
	public static void saveNewComplaint(Complaint complaint) {
		
		System.out.println(complaint.getComplaintDetails());
		
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.now();
	    String date = dtf.format(localDate);
	    
		String sql = "INSERT INTO complaint (date, status, complaintDetails, connectionID)"
                + " VALUES (?, ?, ?, ?)";
		DataAccess.getInstance().update(sql, date, "pending", complaint.getComplaintDetails(), 1); 
	
	}
	
	public static int getId() {
		String sql = "SELECT MAX(ID) FROM complaint";
		return DataAccess.getInstance().queryForInt(sql);
	}
}