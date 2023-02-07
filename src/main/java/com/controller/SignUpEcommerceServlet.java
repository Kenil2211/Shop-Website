package com.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.DBConnection;
import dao.UserDao;

public class SignUpEcommerceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String upwd = request.getParameter("upwd");
	
		UserDao udao=UserDao.getInstance();
		RequestDispatcher rd=null;
		UserBean ubean = new UserBean(uname, uemail, upwd);
		ArrayList<UserBean> l = new ArrayList<UserBean>(); 
		ArrayList<UserBean> l1 = new ArrayList<UserBean>(); 
		l = udao.existingUser(uemail);
		if(l.size()==0)
		{			
			udao.addUser(ubean);
			
			l1= udao.existingUser(uemail);
			
			Cookie c = new Cookie("Username",l1.get(0).getName());
			response.addCookie(c);
			
			int id=l1.get(0).getUserId();
			String id1 = Integer.toString(id);
			Cookie c1= new Cookie("Userid",id1);
			response.addCookie(c1);
			
			response.sendRedirect("HomeEcommerce.jsp");
		}
		else
		{
			rd = request.getRequestDispatcher("SignupEcommerce.jsp");
			request.setAttribute("EmailInUse", "Email is Already in Use");
			request.setAttribute("name", uname);
			rd.forward(request, response);
		}
			
	}

}
