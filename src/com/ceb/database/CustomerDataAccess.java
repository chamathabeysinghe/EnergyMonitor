package com.ceb.database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class CustomerDataAccess {
	final private DriverManagerDataSource dataSource = new DriverManagerDataSource();
	final private JdbcTemplate jdbcTemplate; 
	private static CustomerDataAccess instance;
	private CustomerDataAccess(){
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/energymonitor");
        dataSource.setUsername("customer");
        dataSource.setPassword("password");
        jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public static JdbcTemplate getInstance(){
		if(instance==null){
			instance=new CustomerDataAccess();
		}
		return instance.jdbcTemplate;
	}
}