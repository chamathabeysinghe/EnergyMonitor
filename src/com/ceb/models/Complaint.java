package com.ceb.models;

public class Complaint {
	private int id; 
	private String date;
	private String status;
    private String complaintDetails;
    private int connectionID;
	
	// standard getters and setters
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComplaintDetails() {
		return complaintDetails;
	}
	public void setComplaintDetails(String complaintDetails) {
		this.complaintDetails = complaintDetails;
	}
	public int getConnectionID() {
		return connectionID;
	}
	public void setConnectionID(int connectionID) {
		this.connectionID = connectionID;
	}
	
}