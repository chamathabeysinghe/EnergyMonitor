package com.ceb.models;

import com.ceb.database.DataAccess;

public class ModelUtility {

	public static class ModelUtilityDAO {
		
		public static int getComplainCount(){
			String sql="SELECT  count(*) from complaint where status='processing'";
			int i=DataAccess.getInstance().queryForObject(sql, Integer.class);			
			return i;
		}
		
		public static int getConnectionRequestCount(){
			String sql="SELECT  count(*) from newconnectionrequest where status='processing'";
			int i=DataAccess.getInstance().queryForObject(sql, Integer.class);			
			return i;
		}
		
		public static int getConnectionChangeCount(){
			String sql="SELECT  count(*) from changerequest where status='processing'";
			int i=DataAccess.getInstance().queryForObject(sql, Integer.class);			
			return i;
		}
		
		public static int getCustomerCount(){
			String sql="SELECT  count(*) from customer";
			int i=DataAccess.getInstance().queryForObject(sql, Integer.class);			
			return i;
		}
		
		
	}
	
	
}
