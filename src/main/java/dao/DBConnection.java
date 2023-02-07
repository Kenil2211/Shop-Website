package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// DataBaseName - MySql
public class DBConnection 
{
	 
	
	private static Connection conn = null; 
	private DBConnection() 
	{}
	
	public static Connection getDbInstance() 
	{
		if(conn==null) 
		{
			conn = getConnection();
		}
		return conn;
	}
	// 2) create GetConnection Method
	private static Connection getConnection() 
	{
		String urlName = "jdbc:postgresql://localhost/Ecommerce";
		String driverClass ="org.postgresql.Driver";
		String userName = "postgres";
		String password = "postgres";
		
//		 String urlName      ="jdbc:mysql://localhost:3306/jdbc";
//		 String driverClass  ="com.mysql.cj.jdbc.Driver";
//		 String userName     ="root";
//		 String password="";

		
		Connection conn = null;
		try 
		{
			// 3) Load Driver Class
			Class.forName(driverClass);
			
			// 4) pass credential into DriverManager's getConnection Method
			conn = DriverManager.getConnection(urlName, userName, password);
			
			// 5) validate  object
			if(conn != null) 
			{
				System.out.println("Db connected : " + conn);
			}else 
			{
				System.out.println("Db not connected : " + conn);
			}
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		System.out.println();
		getConnection();
	}
}