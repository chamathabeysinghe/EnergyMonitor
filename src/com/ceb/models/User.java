package com.ceb.models;

import java.util.List;

import com.ceb.database.BillRowMapper;
import com.ceb.database.DataAccess;

public class User {
	private String firstName;
	private String lastName;
	private String nameWithInitials;
	private String NIC;
	private String address;
	private int telphone;
	private int mobilenumber;
	private String email;
	

	private String password;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNameWithInitials() {
		return nameWithInitials;
	}
	public void setNameWithInitials(String nameWithInitials) {
		this.nameWithInitials = nameWithInitials;
	}
	
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getTelphone() {
		return telphone;
	}
	public void setTelphone(int telphone) {
		this.telphone = telphone;
	}

	
	
	public int getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(int mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static class userDAO{
		
		public static List<User> getAllUsers(){
			String sql = "SELECT * FROM CUSTOMER" ;
			List<User> userList = DataAccess.getInstance().query(sql, new UserRowMapper());
		
		}
	}
	
	
	
	
}

