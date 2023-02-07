package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.UserBean;


public class UserDao
{	
	private UserDao()
	{}
	
	static private UserDao udao=null;
	
	public static UserDao getInstance()
	{
		if(udao == null)
		{
			return new UserDao();
		}
		return udao;
	}
	
	public int addUser(UserBean ubean)
	{
		int rowAdded=0;
		
		String insertQuery="Insert into users(name,email,pwd) values "
				+ "('"+ubean.getName()+"','"+ubean.getEmail()+"','"+ubean.getPassword()+"')";
		
		Connection conn=DBConnection.getDbInstance();
		
		if(conn!=null)
		{
			try 
			{
				Statement stmt=conn.createStatement();
				rowAdded = stmt.executeUpdate(insertQuery);
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else {
			System.out.println("DB not found!");
		}
		
		return rowAdded;
	}

	public ArrayList<UserBean> isUser(String e,String p) 
	{
		Connection conn=DBConnection.getDbInstance();
		Statement stmt=null;
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		
			String getRecordQuery= "select * from users where email='"+e+"' and pwd='"+p+"'";
			ResultSet rs=null;
			if(conn != null)
			{
				try 
				{
					stmt=conn.createStatement();
					rs = stmt.executeQuery(getRecordQuery);
					UserBean ubean=null; 
					
					while(rs.next())
					{
						int id = rs.getInt(1);
						String name = rs.getString(2);
						String email = rs.getString(3);
						String pwd = rs.getString(4);
						ubean = new UserBean(id,name,email,pwd);
						list.add(ubean);
						System.out.println("dao --isuser--return list");
						return list;
					}
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
			else
			{
				System.out.println("DB not connected");
			}
		return list;
	
	}

	public ArrayList<UserBean> existingUser(String e)
	{
		Connection conn=DBConnection.getDbInstance();
		Statement stmt=null;
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		
		String checkEmailQuery = "select * from users where email='"+e+"'";
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(checkEmailQuery);
			UserBean ubean=null;
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String pwd = rs.getString(4);
				ubean = new UserBean(id,name,email,pwd);
				list.add(ubean);
				
				return list;
			}
			
		}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
			return list;
		}
		
	}















