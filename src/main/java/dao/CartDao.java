package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.CartBean;

public class CartDao 
{
	Connection conn = DBConnection.getDbInstance();
	
	private CartDao() 
	{}
	
	static CartDao cdao=null;
	public static CartDao getInstance()
	{
		if(cdao==null)
		{
			return new CartDao();
		}
		return cdao;
	}
	
	public boolean productAlreadyExists(String query)
	{
		if(conn != null)
		{
			try 
			{
				Statement stmt = conn.createStatement();
				ResultSet rs= stmt.executeQuery(query);
				if(rs.next())
				{
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Db not found---update()");
		}
		return false;
	}
	
	public void addToCart(CartBean cbean)
	{
		String insertQuery = "insert into carts(uid,pid,pname,price,qty) values ('"+cbean.getUid()+"','"+cbean.getPid()+"','"+cbean.getPname()+"','"+cbean.getPrice()+"','"+cbean.getQty()+"')";
		if(conn != null)
		{
			try 
			{
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(insertQuery);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Db not found---addtocart()");
		}
	}
	
	
	public ArrayList<CartBean> getCart(String id)
	{
		String query= "select * from carts where uid = "+id+"";
		ArrayList<CartBean> list=new ArrayList<CartBean>();
		CartBean cbean1=null;
		if(conn!=null)
		{
			Statement stmt=null;
			try 
			{
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next())
				{
					//cid,uid,pid,pnmae,price,qty
					int cid=rs.getInt(1);
					int uid=rs.getInt(2);
					int pid=rs.getInt(3);
					String pname=rs.getString(4);
					String price=rs.getString(5);
					String qty=rs.getString(6);
					cbean1=new CartBean(Integer.toString(cid),Integer.toString(uid),Integer.toString(pid),pname,price,qty);
					list.add(cbean1);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.println("db not connected -- getcart()");
		}
		return list;
	}

	public void updateQty(String query)
	{
		if(conn != null)
		{
			try 
			{
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(query);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Db not found---update()");
		}
	}
	
	public void removeProductFromCart(String query)
	{
		if(conn != null)
		{
			try 
			{
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(query);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Db not found---update()");
		}
	}
	
	public void clearUserCart(String uid)
	{
		String Query= "delete from carts where uid="+uid;
		if(conn != null)
		{
			try 
			{
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(Query);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("DB  not connecected in clearUsercart");
		}
	}
}

