package com.ceb.database;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class DataAccess {
	final private DriverManagerDataSource dataSource = new DriverManagerDataSource();
	final private JdbcTemplate jdbcTemplate; 
	private static DataAccess instance;
	private DataAccess(){
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/energymonitor");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        jdbcTemplate = new JdbcTemplate(dataSource);
        
        
	}
	
	public static JdbcTemplate getInstance(){
		if(instance==null){
			instance=new DataAccess();
		}
		return instance.jdbcTemplate;
	}
	
}
