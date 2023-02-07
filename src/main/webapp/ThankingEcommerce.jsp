<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.ProductDao" 
		import="bean.ProductBean"
		import="java.util.ArrayList"
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>APKI APNI DUKAN</title>
<style type="text/css">
	a{
			font-size:20px
			text-decoration: none;
			color:yellow;
		}
	.Nav {
        border: 2px solid ;
        display: flex ;
        flex-direction: row;
        
        gap: 100px;
       padding-top: 5px;
       background-color: silver;
       padding-bottom: 3px;
    }

	.navbar :hover {
	padding:2px;
    border: 1px solid ;
    background-color:lightblue;
    border-radius: 5px;
    color: red;
</style>
</head>
<body>
	<%
		Cookie cookies[]= request.getCookies();
		String uid="";
		String uname="";
		for(Cookie c:cookies)
		{
			if(c.getName().equals("Username"))
			{
				uname = c.getValue();
			}
			if(c.getName().equals("Userid") )
			{
				uid= c.getValue(); 
			}
		}
	%>
	<div class="Nav" style="background-color: black">
            <div class="navbar" id="btn1"><a href="#" style="font-size:30px;">Home</a></div>
            <div class="navbar" ><a href="#" style="font-size:30px;margin-left:30px">Hello, <%=uname==null?"User":uname%></a></div>
            <div class="navbar" ><a href="MyCartEcommerce.jsp" style="font-size:30px;margin-left:30px">Cart</a></div>
            <div class="navbar" ><a href="OrderEcommerce.jsp" style="font-size:30px;margin-left:30px">My Order</a></div>
            <div class="navbar" ><a href="PastOrderEcommerce.jsp" style="font-size:30px;margin-left:30px">Past Orders</a></div>
            <div class="navbar" ><a href="#" style="font-size:25px;margin-left:10px">Log Out</a></div>
     </div>
     
	<h1 align="center">Thank You for Shopping with us..Visit again!!</h1>
     
     <a href="HomeEcommerce.jsp"><button style="font-size: 2rem"> Continue Shopping</button> </a>
</body>
</html>