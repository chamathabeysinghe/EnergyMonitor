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
			String sql="SELECT  count(*) from newconnectionrequest where status='pending'";
			int i=DataAccess.getInstance().queryForObject(sql, Integer.class);			
			return i;
		}
		
		public static int getConnectionChangeCount(){
			String sql="SELECT  count(*) from changerequest where status='pending'";
			int i=DataAccess.getInstance().queryForObject(sql, Integer.class);			
			return i;
		}
		
		
		public static int getComplainCount(int customerID){
			String sql="SELECT  count(*) from complaint,connection where status='pending' and connection.id=complaint.connectionID and connection.customerID=?";
			int i=DataAccess.getInstance().queryForObject(sql,new Object[]{customerID}, Integer.class);			
			return i;
		}
		
		public static int getConnectionRequestCount(int customerID){
			String sql="SELECT  count(*) from newconnectionrequest where status='pending' and customerID=?";
			int i=DataAccess.getInstance().queryForObject(sql,new Object[]{customerID} ,Integer.class);			
			return i;
		}
		
		public static int getConnectionChangeCount(int customerID){
			String sql="SELECT  count(*) from changerequest,connection where status='processing' and connection.id=changeRequest.connectionID and connection.customerID=?";
			int i=DataAccess.getInstance().queryForObject(sql,new Object[]{customerID} , Integer.class);			
			return i;
		}
		
		
		
		public static int getCustomerCount(){
			String sql="SELECT  count(*) from customer";
			int i=DataAccess.getInstance().queryForObject(sql, Integer.class);			
			return i;
		}
		
		public static double remainingBalance(int customerID){
			String sql="select (A.BillTotal-B.PayementTotal) from (SELECT COALESCE(SUM(bill.amount),0) as BillTotal from bill,connection where bill.connectionID=connection.id and connection.customerID=?) as A,(SELECT COALESCE(SUM(payment.amount),0) as PayementTotal from payment,connection where payment.connectionID=connection.id and connection.customerID=?) as B";
			double i=DataAccess.getInstance().queryForObject(sql,new Object[]{customerID,customerID}, Double.class);			

			return i;
		}
		
		
	}
	
	
}
