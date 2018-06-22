package common.util.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

public class BaseDaoImpl {
	protected static QueryRunner queryRunner=new QueryRunner();

	private static Properties properties=new Properties();
	protected static Connection connection;
	protected static String sql;
	protected static Object[] params;
	protected static Object[][] twoParams; //批量处理参数
	protected static List<Object> listParams;
	private static DataSource dataSource;
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
/*	static{
		try{
			InputStream is =BaseDaoImpl.class.getClassLoader().getResourceAsStream("jdbc.properties");  
			properties.load(is);
			}catch(IOException e){
			e.printStackTrace();
		}
		 
		try{
		dataSource = BasicDataSourceFactory.createDataSource(properties);
		}catch(Exception e){
		e.printStackTrace();
		}
	}*/
	static{
		InputStream is=BaseDaoImpl.class.getClassLoader().getResourceAsStream("dbcp.properties");
		Properties properties=new Properties();
		try {
			properties.load(is);
			driver=properties.getProperty("driverClassName");
			url=properties.getProperty("url");
			user=properties.getProperty("username");
			password=properties.getProperty("password");
            getConnection();
		    
		} catch (Exception e) { 
			e.printStackTrace();
		} 
	}
/*	public static Connection getConnection(){
		         
		try{
			connection = dataSource.getConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try {
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}*/
	 public static void getConnection() throws Exception{
			Class.forName(driver);
		    connection=DriverManager.getConnection(url,user,password);
		    
	  }
	public static void closeAll() {

				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
	
	public static int batchProcessing() throws SQLException {
		int result=0;
		int[] count=queryRunner.batch(connection, sql, twoParams);
		for (int i = 0; i < count.length; i++) {
			System.out.println(i);
			if(count[i]<=0){
				result=1;
				break;
			}
		}
		return result;	
	}
	
	public static void main(String[] args) throws Exception {
		getConnection();
		sql="insert into gwym (jobId,ymbhId) values(?,?) ";
		twoParams = new Object[10][2];
		int index1=0;
		for (int i=0;i<twoParams.length;i++) {
			twoParams[i][0]="2";
			twoParams[i][1]="17"; 
		}
		try {
			batchProcessing();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
