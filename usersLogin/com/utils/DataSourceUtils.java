package com.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DataSourceUtils {
	private static DataSource dataSource;
	static{
		try {
			
			Properties properties = new Properties();
			properties.load(DataSourceUtils.class.getClassLoader().getResourceAsStream("db.properties"));
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource(){
		return dataSource;
	}
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	public static void main(String[] args) throws SQLException {
	
			System.out.println(DataSourceUtils.getConnection());
	
	}
}
