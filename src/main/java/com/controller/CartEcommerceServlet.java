package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CartBean;
import bean.ProductBean;
import dao.CartDao;

public class CartEcommerceServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException 
    {
    	String pid = request.getParameter("pidCart");
    	String uid = request.getParameter("curr_uid");
    	String pname= request.getParameter("pname");
    	String price= request.getParameter("price");
//    	String pqty= request.getParameter("qty");
    	String pqty="1";
    	
    	String keyForUpdate = (String) request.getParameter("key");
    	
    	CartBean cbean = new CartBean(uid,pid,pname,price,pqty);
    	CartDao cdao= CartDao.getInstance();
    	if(keyForUpdate != null)
    	{
    		System.out.println("Inside of key forUpDATE");
    		String cart_id[] = request.getParameterValues("cart_id");
        	String qty[]=request.getParameterValues("qty");
        	String updateQuery="";
        	for(int i=0;i< qty.length;i++) 
        	{
        		if(Integer.parseInt(qty[i]) == 0)
        		{
        			updateQuery += "delete from carts where cid ="+Integer.parseInt(cart_id[i])+";";
        					
        		}
        		else
        			updateQuery += " update carts set qty="+Integer.parseInt(qty[i])+" where cid ="+Integer.parseInt(cart_id[i])+";";
        		
        	}
        	cdao.updateQty(updateQuery);
        	
        	response.sendRedirect("OrderEcommerce.jsp");
        	
    	}
    	else 
    	{
    		String query = "select * from carts where uid = "+Integer.parseInt(uid)+" and pid = "+Integer.parseInt(pid)+";";
    		System.out.println(query);
    		if(cdao.productAlreadyExists(query))
    		{
    			System.out.println("Product already in cart");
    		}
    		else 
    		{
    			cdao.addToCart(cbean);
    		}
        	response.sendRedirect("HomeEcommerce.jsp");
    	}
    	
	}

}
