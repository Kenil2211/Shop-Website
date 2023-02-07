package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.ProductDao;
import dao.UserDao;

public class LoginEcommerceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		
		if(email.equals("admin@gmail.com") && pwd.equals("admin123"))
		{
			response.sendRedirect("AdminEcommerce.jsp");
		}
		else
		{
			UserDao udao=UserDao.getInstance();
			
			ArrayList<UserBean> l =new ArrayList<UserBean>();
			l = udao.isUser(email, pwd);
			if(l.size()!=0)
			{
				System.out.println("Dao -- "+l.get(0).getName());
				Cookie c = new Cookie("Username",l.get(0).getName());
				response.addCookie(c);
				int id=l.get(0).getUserId();
				String id1 = Integer.toString(id);
				Cookie c1= new Cookie("Userid",id1);
				response.addCookie(c1);
				response.sendRedirect("HomeEcommerce.jsp");
				
			}
			else
			{
				request.setAttribute("Invalid", "Email or Password Incorrect");
				RequestDispatcher rd = request.getRequestDispatcher("LoginEcommerce.jsp");
				
				rd.forward(request, response);
			}
		}
		
	}

}
