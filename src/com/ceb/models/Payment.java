package com.ceb.models;

import java.util.Date;

import com.ceb.database.DataAccess;

public class Payment {
	private int id;
	private String date;
	private double amount;
	private int connectionID;

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

	public int getConnectionID() {
		return connectionID;
	}

	public void setConnectionID(int connectionID) {
		this.connectionID = connectionID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public static class PaymentDAO {
		public static boolean addPayment(Payment payment) {

			String sql = "INSERT INTO payment VALUES(null,?,?,?)";
			Object[] values = { payment.getDate().toString(), payment.getAmount(), payment.getConnectionID() };
			int result = DataAccess.getInstance().update(sql, values);
			if (result > 0) {
				return true;
			}
			return false;
		}

	}
}
