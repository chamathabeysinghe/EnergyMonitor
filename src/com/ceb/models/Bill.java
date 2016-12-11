package com.ceb.models;

import java.util.List;

import com.ceb.database.BillRowMapper;
import com.ceb.database.DataAccess;

public class Bill {
	
	private double usage;
	private String month;
	private String year;
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
	
	
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
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
			String sql="SELECT * FROM Bill WHERE id=?";
			Bill result=DataAccess.getInstance().queryForObject(sql,new Object[]{billID},new BillRowMapper());
			return result;
		}
		public static List<Bill> getBill(int billID,int connectionID,int year, int month){
			String sql="SELECT * FROM  Bill WHERE ("+billID+"<0 or id=?) and ("+connectionID+"<0 or connectionID=?) and ("+year+"<0 or year=?) and ("+month+"<0 or month=?) ";
			List<Bill> resultList=DataAccess.getInstance().query(sql,new Object[]{billID,connectionID,year,month},new BillRowMapper());
			return resultList;
		}
		public static boolean addBill(Bill bill){
			
			String sql="INSERT INTO bill VALUES(?,?,?,?)";
			Object[] values={bill.getUsage(),bill.getMonth(),bill.getAmount(),bill.getConnectionID()};
			int result=DataAccess.getInstance().update(sql, values);
			if(result>0){
				return true;
			}
			return false;
		}
	}
	

}
