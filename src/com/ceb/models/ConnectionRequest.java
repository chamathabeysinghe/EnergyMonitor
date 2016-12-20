package com.ceb.models;

public class ConnectionRequest {
	private int id; 
	private String date;
	private String status;
    private String newConnectionDetails;
    private int customerID;
	
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
	public String getNewConnectionDetails() {
		return newConnectionDetails;
	}
	public void setNewConnectionDetails(String newConnectionDetails) {
		this.newConnectionDetails = newConnectionDetails;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
}