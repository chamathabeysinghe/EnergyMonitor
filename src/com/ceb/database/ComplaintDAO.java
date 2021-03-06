package com.ceb.database;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.ceb.models.Complaint;
import com.mysql.cj.api.jdbc.Statement;

public class ComplaintDAO {
	
	public static void saveNewComplaint(Complaint complaint,int customerID) {
		
		System.out.println(complaint.getComplaintDetails());
		
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.now();
	    String date = dtf.format(localDate);
	    
		String sql = "INSERT INTO complaint (date, status, complaintDetails, connectionID)"
                + " VALUES (?, ?, ?, ?)";
		DataAccess.getInstance().update(sql, date, "pending", complaint.getComplaintDetails(), customerID); 
	
	}
	
	public static void updateComplaint(int complaintID) {
		
		
	   	    
		String sql = "UPDATE complaint SET status='done' WHERE id=?";
		DataAccess.getInstance().update(sql,complaintID); 
	
	}
	
	public static int getId() {
		String sql = "SELECT MAX(ID) FROM complaint";
		return DataAccess.getInstance().queryForInt(sql);
	}
	
	public static List<Complaint> getAllComplaints() {
		String sql = "SELECT * FROM complaint where status=\"pending\"";
		/*List<Complaint> complaints = new ArrayList<Complaint>();
		List<Map> rows = DataAccess.getInstance().queryForList(sql);*/
		List<Complaint> complaints  = DataAccess.getInstance().query(sql, new BeanPropertyRowMapper<Complaint>(Complaint.class));
		return complaints;
		
	}
}