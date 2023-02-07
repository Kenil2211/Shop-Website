package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.OrderBean;
import bean.OrderHistoryBean;

public class OrderDao 
{
	private OrderDao()
	{}
	
	private static OrderDao odao=null;
	
	public static OrderDao getInstance()
	{
		if(odao == null)
		{
			return new OrderDao();
		}
		return odao;
	}
	
	Connection conn=DBConnection.getDbInstance();
	public void addOrder(String amt,String uid)
	{
		if(conn!=null)
		{
			try 
			{
				Statement stmt = conn.createStatement();
				OrderBean obean=new OrderBean(uid,amt);
				System.out.println(obean.getDate() + "---"+obean.getTime());
				String d=obean.getDate();
				String t=obean.getTime();
				String query = "insert into orders (uid,date,time,total) values("+uid+",'"+d+"','"+t+"','"+amt+"')";
				stmt.executeUpdate(query);
				
				System.out.println("inserted orders..");
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Db not connected in addorder()");
		}
	}

	public int getOrderId()
	{
		String query="select * from orders order by oid DESC fetch first 1 rows only";
		if(conn!=null)
		{
			try 
			{
				Statement stmt= conn.createStatement();
				ResultSet rs=stmt.executeQuery(query);
				rs.next();
				return rs.getInt(1);
				
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			} 
		}
		else 
		{
			System.out.println("Db not connecected in getorderid");
		}
		return -1;
	}

	public ArrayList getOrderHistory(String uid)
	{
		ArrayList<OrderHistoryBean> result = new ArrayList<OrderHistoryBean>();
		if(conn != null)
		{
			String Query = "select * from orders o"
					+ " inner join orderdetails od using (oid) where o.uid = "+uid;
			try 
			{
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(Query);
				
				while(rs.next())
				{
					int order_id = rs.getInt(1);
					String orderDate = rs.getString(3);
					String pname = rs.getString(9);
					String qty = rs.getString(10);
					String price = rs.getString(11);
					String total = rs.getString(12);
					
					OrderHistoryBean ohbean = new OrderHistoryBean(orderDate,order_id,pname,qty,price,total); 
					
					//res.add-list
					result.add(ohbean);
				}
				
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			System.out.println("past orders query - "+Query);
		}
		else
		{
			System.out.println("DB not connected in getorderhistory");
		}
		return result;
	}
	
	
}
