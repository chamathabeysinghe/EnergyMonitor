package com.ceb.database;
import com.ceb.models.Complaint;

public class ComplaintDAO {
	
	public static void saveNewComplaint(Complaint complaint) {
		
		System.out.println(complaint.getComplaintDetails());
		String sql = "INSERT INTO complaint (id, complaintDetails, connectionID)"
                + " VALUES (?, ?, ?)";
		DataAccess.getInstance().update(sql, 1, complaint.getComplaintDetails(), 1); //Beware of Primary key - Foreign key violence :P 
	}
}