package com.ceb.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ceb.database.BillRowMapper;
import com.ceb.database.DataAccess;
import com.ceb.database.UserRowMapper;

public class User {
	private int id;
	private String userType;
	private String firstName;
	private String lastName;
	private String NIC;
	private String phoneNumber;
	private String email;
	private String password;

	
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static class userDAO {

		public static List<User> getAllUsers() {
			String sql = "SELECT * FROM CUSTOMER";
			List<User> userList = DataAccess.getInstance().query(sql, new UserRowMapper());
			return userList;

		}
		public static User getUserByID(int ID){
			String sql="SELECT * FROM user WHERE id=?";
			User result=DataAccess.getInstance().queryForObject(sql,new Object[]{ID},new UserRowMapper());
			return result;
		}
		public static int getUserCount(){
			String sql="SELECT * FROM user ORDER BY id DESC LIMIT 1;";
			User result=DataAccess.getInstance().queryForObject(sql,new Object[]{},new UserRowMapper());
			return result.getId();
		}

		public static boolean addUser(User user) {
			String sql ="Insert into user(email,password,userType,firstName,lastName,NIC,phoneNumber) Values(?,password(?),?,?,?,?,?)";
			
//			String sql = "INSERT INTO customer VALUES(null,?,?,?,?,?,?,?,?)";
			System.out.println(user.getEmail()+"INSIDE THE CONTROLLERRR");
//			Object[] values = {user.getEmail(), user.getPassword(), "consumer",user.getFirstName(),user.getLastName() };
			Object[] values = {user.getEmail(),user.getPassword(),user.getUserType(),user.getFirstName(),user.getLastName(),user.getNIC(),user.getPhoneNumber() };
			int result = DataAccess.getInstance().update(sql, values);
			if (result > 0) {
				return true;
			}
			return false;
		}
		
		public static User logUser(User user){
			String sql="Select * from user where user.email=? and user.password=password(?)";
			System.out.println("CONNECTING DATABASE "+user.getEmail()+"   "+user.getPassword());
			User loggedUser=DataAccess.getInstance().queryForObject(sql,new Object[]{user.getEmail(),user.getPassword()},new RowMapper<User>(){

				@Override
				public User mapRow(ResultSet rs, int arg1) throws SQLException {
					User user=new User();
					System.out.println(rs.getInt("id"));
					user.setId(rs.getInt("id"));
					user.setFirstName(rs.getString("firstName"));
					user.setLastName(rs.getString("lastName"));
					user.setUserType(rs.getString("userType"));
					
					return user;
				}
				
			});
			System.out.println("USER LOGGING "+loggedUser.getId());
			
			return loggedUser;
			
			
		}
	}

}
