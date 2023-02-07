package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.CartBean;

public class OrderDetailDao 
{
	private OrderDetailDao()
	{}
	
	private static OrderDetailDao oddao=null;
	
	public static OrderDetailDao getInstance()
	{
		if(oddao == null)
		{
			return new OrderDetailDao();
		}
		return oddao;
	}
	
	Connection conn=DBConnection.getDbInstance();
	
	//curr_oid,uid,pids,pnames,pqty,prices
	public void addOrderDetail(int c_oid,String uid,ArrayList<CartBean> list1)
	{
		String Query = "";
		int total=0;
		CartBean cbean=null;
		for(int i=0;i<list1.size();i++)
		{
			cbean=list1.get(i);
			String pid=cbean.getPid();
			String pname=cbean.getPname();
			String price=cbean.getPrice();
			String qty=cbean.getQty();
			total = Integer.parseInt(price) * Integer.parseInt(qty);
			Query += "insert into orderdetails(oid,uid,pid,pname,pqty,price,total) values "
					+ "("+c_oid+",'"+uid+"','"+pid+"','"+pname+"','"+qty+"','"+price+"','"+total+"');";
			
		}
		
		if(conn!=null)
		{
			try 
			{
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(Query);
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("DB not connected in addorderdetails");
		}
		
//		System.out.println("Query == "+Query);
	}
	
	
}
