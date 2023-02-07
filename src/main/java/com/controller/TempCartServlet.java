package com.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CartBean;
import bean.ProductBean;
import dao.CartDao;


public class TempCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException 
    	{
    			CartDao cdao=CartDao.getInstance();
        		String productId = (String)request.getParameter("pidRemove");
        		String userId = (String) request.getParameter("uidRemove");
//        		System.out.println("product -"+productId+"--user-"+userId);
        		String Query = "delete from carts where uid = "+Integer.parseInt(userId)+" and pid="+Integer.parseInt(productId)+";";
        		System.out.println("remove--"+Query);
        		cdao.removeProductFromCart(Query);
        		response.sendRedirect("MyCartEcommerce.jsp");
        	
    	}

}
