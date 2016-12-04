package com.ceb.models;

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
	
	
	
	
	
}
