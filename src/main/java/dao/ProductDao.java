package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.ProductBean;

public class ProductDao 
{
	Connection conn=DBConnection.getDbInstance();
	
	private ProductDao()
	{}
	
	static ProductDao pdao=null;
	
	public static ProductDao getInstance()
	{
		if(pdao == null)
		{
			return new ProductDao();
		}
		return pdao;
	}
	
	public int addProduct(ProductBean pbean)
	{
		String insertQuery = "insert into products(name,quantity,price,imgurl) values "
				+ "('"+pbean.getProductName()+"' , '"+pbean.getProductQty()+"' , '"+pbean.getProductPrice()+"' , '"+pbean.getImgurl()+"')";
		Statement stmt;
		int rowsAdded= 0;
		if(conn != null)
		{
			try 
			{
				stmt=conn.createStatement();
				rowsAdded = stmt.executeUpdate(insertQuery);				
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}	
		else 
		{
			System.out.println("DB not Connected..");			
		}
		
		return rowsAdded;
	}
	
	public boolean updateProduct(ProductBean pbean,String id)
	{
		Connection conn=DBConnection.getDbInstance();
		String updateQuery = "update products set name='"+pbean.getProductName()+"', quantity ='"+pbean.getProductQty()+"', price ='"+pbean.getProductPrice()+"', imgurl ='"+pbean.getImgurl()+"' where pid="+id+"";
		if(conn != null)
		{
			try 
			{
				System.out.println("Update called..");
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(updateQuery);
				
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			
		}
		return false;
	}
	
	public ArrayList<ProductBean> getAllProducts()
	{
		String getProductsQuery="select * from products";
		Connection conn=DBConnection.getDbInstance();
		ResultSet rs;
		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();
		if(conn != null)
		{
			try 
			{
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(getProductsQuery);
				ProductBean pbean = null;
				while(rs.next())
				{
					//pid,name,quantity,price,imgurl
					int pid= rs.getInt(1);
					String name = rs.getString(2);
					String quantity = rs.getString(3);
					String price = rs.getString(4);
					String imgurl = rs.getString(5);
					
					pbean = new ProductBean(pid, name,quantity,price, imgurl);
					productList.add(pbean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Db not connected - getallproducts()");
		}
		return productList;
	}
	
	public boolean deleteProduct(String id)
	{
		Connection conn = DBConnection.getDbInstance();
		String deleteQuery = "delete from products where pid = "+id;
		int isDeleted;
		if(conn != null)
		{
			Statement stmt;
			try 
			{
				stmt = conn.createStatement();
				isDeleted = stmt.executeUpdate(deleteQuery);
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("db not connected -- deleteproduct()");
		}
		return false;		
	}
}
