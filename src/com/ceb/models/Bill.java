package com.ceb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.ceb.database.BillRowMapper;
import com.ceb.database.DataAccess;

public class Bill {
	
	private double usage;
	private String month;
	private int year;
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
	public int getYear() {
		return year;
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
	
	
	public void setYear(int year) {
		this.year = year;
	}
	public static String[] getUsageRepor(int connectionID,int year){
		
		String monthList[]={"January","February","March","April","May","June","July","August","September","Octomber","November","December"};
		
		ArrayList<String> monthArray=new ArrayList<>();
		ArrayList<Double> usageArray=new ArrayList<>();
		for(String month:monthList){
			monthArray.add(month);
			usageArray.add(0.0);
		}
		
		String months="[";
		String usage="[";
		
		for(Bill b:BillDAO.getBillsByConnection(connectionID,year)){
			//usageMap.put(b.getMonth(),b.getUsage());
			usageArray.set(monthArray.indexOf(b.getMonth()), b.getUsage());
			
		}
		
		for(String month:monthArray){
			months+="'"+month+"',";
			usage+=usageArray.get(monthArray.indexOf(month))+",";
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
		public static List<Bill> getBillsByConnection(int connectionID,int year){
			String sql="SELECT * FROM Bill WHERE connectionID=? and year=?";
			List<Bill> resultList=DataAccess.getInstance().query(sql,new Object[]{connectionID,year},new BillRowMapper());
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
