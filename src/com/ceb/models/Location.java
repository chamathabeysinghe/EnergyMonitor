package com.ceb.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceb.database.DataAccess;

public class Location {
	private int locationID;
	private String region;
	private String province;
//	private String officeAddress;
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		System.out.println(region);
		this.region = region;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID){
		this.locationID=locationID;
	}
	
	public static class LocationDAO{
		public static void saveNewLocation(Location location) {
			
			String sql = "INSERT INTO location (region, province) VALUES (?, ?)";
			DataAccess.getInstance().update(sql, location.getRegion(), location.getProvince()); 
		
		}
	}
	
}
