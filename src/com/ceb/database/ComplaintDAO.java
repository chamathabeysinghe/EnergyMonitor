package com.ceb.database;
import com.ceb.models.Complaint;

public class ComplaintDAO {
	
	public static void saveNewComplaint(Complaint complaint) {
		
		System.out.println(complaint.getComplaintDetails());
		/*String sql = "INSERT INTO complaint (id, date, status, complaintDetails, connectionID)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
		DataAccess.getInstance().update(sql, complaint.getId(), complaint.getDate(), complaint.getStatus(), complaint.getComplaintDetails(), complaint.getConnectionID()); */ 
	
		String sql = "INSERT INTO complaint (id, complaintDetails, connectionID)"
                + " VALUES (?, ?, ?)";
		DataAccess.getInstance().update(sql, 1, complaint.getComplaintDetails(), 1); 
	
	}
}