package com.ceb.models;

import com.ceb.database.DataAccess;

public class Connection {
	private int id;
	private String address;
	private String category;
	private int locationID;
	private int customerID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	
	
	public static class ConnectionDAO{
		public static boolean addConnection(Connection connection) {

			String sql = "INSERT INTO Connection VALUES(null,?,?,?,?)";
			Object[] values = { connection.getAddress(),connection.getCategory(),connection.getLocationID(),connection.getCustomerID()};
			int result = DataAccess.getInstance().update(sql, values);
			if (result > 0) {
				return true;
			}
			return false;
		}
	}
}
