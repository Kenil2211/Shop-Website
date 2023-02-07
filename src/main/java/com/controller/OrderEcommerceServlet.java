package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CartBean;
import dao.CartDao;
import dao.OrderDao;
import dao.OrderDetailDao;


public class OrderEcommerceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		Cookie cookies[]=request.getCookies();
		String uid="";
		for(Cookie c:cookies)
		{
			if(c.getName().equals("Userid"))
			{
				uid = c.getValue();
				break;
			}
		}
		
		//uid is here
		
		OrderDetailDao oddao = OrderDetailDao.getInstance();
		
		OrderDao odao=OrderDao.getInstance();
		
		String amt = (String)request.getParameter("amt");
		System.out.println("amt = "+amt);
		
		odao.addOrder(amt,uid);
		
		CartBean cbean=null;
		int sum=0;
		int curr_oid = odao.getOrderId();
		ArrayList<CartBean> l =new ArrayList<CartBean>();
		CartDao cdao=CartDao.getInstance();
		l=cdao.getCart(uid);
		
		//inserted data into order details table
		oddao.addOrderDetail(curr_oid, uid,l);
		
		//Clear user's CART..
		cdao.clearUserCart(uid);
		
		//Clean order's Page
		
		
		
		//Thanking page..then continue shopping
		response.sendRedirect("ThankingEcommerce.jsp");
		
	}

}
