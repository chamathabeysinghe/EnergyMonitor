package com.ceb.models;

import java.util.ArrayList;
import java.util.List;

import com.ceb.database.DataAccess;
import com.ceb.database.EnergyConsumptionRowMapper;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class EnergyConsumption {
	
	private String timeStamp;
	private int usage;
	private Location location;
	private int recordID;
	
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
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
	public String getDate(){
		throw new NotImplementedException();
	}
	private String getTime(){
		throw new NotImplementedException();
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
//		public static List<EnergyConsumption> getEnergyConsumptionRecordsByTimeStamp(int locationID){
//			String sql="SELECT * FROM EnergyConsumption WHERE locationID=?";
//			List<EnergyConsumption> resultList=DataAccess.getInstance().query(sql,new Object[]{locationID},new EnergyConsumptionRowMapper());
//			return resultList;
//		}
		
		
	}
	
	
	
}
