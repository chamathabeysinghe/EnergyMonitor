package com.ceb.models;

public class Location {
	private int locationID;
	private String region;
	private String province;
//	private String officeAddress;
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
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
	
	
	
}
