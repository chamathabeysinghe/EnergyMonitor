package com.ceb.models;

public class ChangeRequest {
	private int id; 
	private String date;
	private String status;
    private String changeDetails;
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
	public String getChangeDetails() {
		return changeDetails;
	}
	public void setChangeDetails(String changeDetails) {
		this.changeDetails = changeDetails;
	}
	public int getConnectionID() {
		return connectionID;
	}
	public void setConnectionID(int connectionID) {
		this.connectionID = connectionID;
	}
}