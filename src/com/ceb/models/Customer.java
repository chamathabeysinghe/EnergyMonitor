package com.ceb.models;

import com.ceb.database.DataAccess;

public class Customer {
	private int id;
	private String name;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static class CustomerDAO {
		public static boolean addCustomer(Customer customer) {

			String sql = "INSERT INTO customer VALUES(?,?,?)";
			Object[] values = {customer.getId(),customer.getName(),customer.getAddress()};
			int result = DataAccess.getInstance().update(sql, values);
			if (result > 0) {
				return true;
			}
			return false;
		}
	}
}
