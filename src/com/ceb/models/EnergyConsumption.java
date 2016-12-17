package com.ceb.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ceb.database.DataAccess;
import com.ceb.database.EnergyConsumptionRowMapper;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class EnergyConsumption {
	
	private int year;
	private int month;
	private int date;
	private int hour;
	private int minute;
	private int second;
	
	private int usage;
	private Location location;
	private int recordID;
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}
	public int getUsage() {
		return usage;
	}
	public void setUsage(int usage) {
		this.usage = usage;
	}
	public Location getLocationID() {
		return location;
	}
	public void setLocationID(Location location) {
		this.location = location;
	}
	public int getRecordID() {
		return recordID;
	}
	public int getDate() {
		return date;
	}


	public static class EnergyConsumptionDAO{
		public static List<EnergyConsumption> getAllEnergyConsumptionRecords(){
			String sql="SELECT * FROM EnergyConsumption";
			List<EnergyConsumption> resultList=DataAccess.getInstance().query(sql, new EnergyConsumptionRowMapper());
			return resultList;
		}
		public static List<EnergyConsumption> getEnergyConsumptionRecordsByLocation(int locationID){
			String sql="SELECT * FROM EnergyConsumption WHERE locationID=?";
			List<EnergyConsumption> resultList=DataAccess.getInstance().query(sql,new Object[]{locationID},new EnergyConsumptionRowMapper());
			return resultList;
		}
		public static EnergyConsumption getEnergyConsumptionRecordsByID(int recordID){
			String sql="SELECT * FROM EnergyConsumption WHERE locationID=?";
			EnergyConsumption result=DataAccess.getInstance().queryForObject(sql,new Object[]{recordID},new EnergyConsumptionRowMapper());
			return result;
		}
		public static String[] getEnergyConsumptionRecordByYear(){
			String sql="SELECt sum(electricUsage) as yearUsage,year(timeStamp) as year from energyconsumption GROUP by year(timeStamp)";
			List<String[]> results =
				DataAccess.getInstance().query(sql, new RowMapper<String[]>(){
					@Override
					public String[] mapRow(ResultSet rs, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						String[] result=new String[2];
						
						result[0]=String.valueOf(rs.getInt("year"));
						result[1]=String.valueOf(rs.getDouble("yearUsage"));
						
						return result;
					}
					
				});
			String yearArray="[";
			String usageArray="[";
			for(String s[]:results){
				yearArray+=s[0]+",";
				usageArray+=s[1]+",";
			}
			yearArray+="]";
			usageArray+="]";
			
			return new String[]{yearArray,usageArray};
		}
		
		public static String[] getCountryEnergyConsumptionCategorizedByTime(){
			String sql="select sum(electricUsage) as totalUsage,if(hour(timeStamp)>6 and hour(timeStamp)<18,'Day','Night') as time from energyconsumption GROUP By hour(timeStamp)>6 and hour(timeStamp)<18";
			List<String[]> results =
					DataAccess.getInstance().query(sql, new RowMapper<String[]>(){
						@Override
						public String[] mapRow(ResultSet rs, int arg1) throws SQLException {
							// TODO Auto-generated method stub
							String[] result=new String[2];
							
							result[0]=String.valueOf(rs.getString("time"));
							result[1]=String.valueOf(rs.getDouble("totalUsage"));
							
							return result;
						}
						
					});
			String timesArray="[";
			String usageArray="[";
			for(String s[]:results){
				timesArray+="'"+s[0]+"',";
				usageArray+=s[1]+",";
			}
			timesArray+="]";
			usageArray+="]";
			return new String[]{timesArray,usageArray};

		}
		
		public static String[] getCountryEnergyConsumptionCategorizedByProvince(){
			String sql="SELECT sum(electricUsage) as totalUsage,location.province as province from energyconsumption,location where location.id=energyconsumption.locationID group by location.province";
			
			List<String[]> results =
					DataAccess.getInstance().query(sql, new RowMapper<String[]>(){
						@Override
						public String[] mapRow(ResultSet rs, int arg1) throws SQLException {
							// TODO Auto-generated method stub
							String[] result=new String[2];
							
							result[0]=String.valueOf(rs.getString("province"));
							result[1]=String.valueOf(rs.getDouble("totalUsage"));
							
							return result;
						}
						
					});
			String provinceArray="[";
			String usageArray="[";
			for(String s[]:results){
				provinceArray+="'"+s[0]+"',";
				usageArray+=s[1]+",";
			}
			provinceArray+="]";
			usageArray+="]";
			return new String[]{provinceArray,usageArray};

		}
		
//		public static List<EnergyConsumption> getEnergyConsumptionRecordsByTimeStamp(int locationID){
//			String sql="SELECT * FROM EnergyConsumption WHERE locationID=?";
//			List<EnergyConsumption> resultList=DataAccess.getInstance().query(sql,new Object[]{locationID},new EnergyConsumptionRowMapper());
//			return resultList;
//		}
		
		
	}
	
	
	
}
