package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProductBean;
import dao.ProductDao;

public class AdminEcommerceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
  			throws ServletException, IOException 
  	{
  		ProductDao pdao= ProductDao.getInstance();
  		String key = request.getParameter("keyAddProduct");
  		
  		if(key!=null &&  key.equals("addnewProduct") )
  		{
  			ProductBean pbean=new ProductBean(request.getParameter("pname"),request.getParameter("qty"),request.getParameter("price"),request.getParameter("imgurl"));
  			pdao.addProduct(pbean);
  		}
  		
  	    String forDelete = request.getParameter("deleteProduct");
  	    if(forDelete != null)
  	    {	 
  	    	pdao.deleteProduct(forDelete);
  	    	System.out.println("delete reached -- "+forDelete);
  	    }
  	    
  	    String forUpdate = request.getParameter("keyupdateProduct");
  	    if(forUpdate != null)
  	    {
  	    	ProductBean pbean=new ProductBean(request.getParameter("pname"),request.getParameter("qty"),request.getParameter("price"),request.getParameter("imgurl"));
  	    	pdao.updateProduct(pbean,forUpdate);
  	    	
  	    }
  	    
  	    
  		response.sendRedirect("AdminEcommerce.jsp");
  	}
}
