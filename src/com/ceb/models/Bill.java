package com.ceb.models;

import java.util.List;

import com.ceb.database.BillRowMapper;
import com.ceb.database.DataAccess;

public class Bill {
	
	private double usage;
	private String month;
	private double amount;
	private int connectionID;
	public double getUsage() {
		return usage;
	}
	public void setUsage(double usage) {
		this.usage = usage;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getConnectionID() {
		return connectionID;
	}
	public void setConnectionID(int connectionID) {
		this.connectionID = connectionID;
	}
	
	public static String[] getUsageRepor(int connectionID){
		String months="[";
		String usage="[";
		
		for(Bill b:BillDAO.getBillsByConnection(connectionID)){
			months+="'"+b.getMonth()+"',";
			usage+=b.getUsage()+",";
		}
		
		usage+="]";
		months+="]";
		return new String[]{months,usage};
	}
	
	
	
	public static class BillDAO{
		public static List<Bill> getAllBills(){
			String sql="SELECT * FROM Bill";
			List<Bill> resultList=DataAccess.getInstance().query(sql, new BillRowMapper());
			return resultList;
		}
		public static List<Bill> getBillsByConnection(int connectionID){
			String sql="SELECT * FROM Bill WHERE connectionID=?";
			List<Bill> resultList=DataAccess.getInstance().query(sql,new Object[]{connectionID},new BillRowMapper());
			return resultList;
		}
		public static Bill getBillByID(int billID){
			String sql="SELECT * FROM EnergyConsumption WHERE id=?";
			Bill result=DataAccess.getInstance().queryForObject(sql,new Object[]{billID},new BillRowMapper());
			return result;
		}
	}
	

}
