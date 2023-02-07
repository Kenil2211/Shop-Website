<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Commerce Website</title>
</head>
<body>
	<h2>Login Page</h2>
	<%
		String error= (String)request.getAttribute("Invalid");
	%>
	<form action="LoginEcommerceServlet" method="post">
	
		<input type="email" name="email" placeholder="email" > <br>
		<input type="text" name="pwd" placeholder="password"> <br>
		<br>
		
		<p style="color: red"> <%=error==null?"":error%> </p>

		<input type="submit" value="Log in"> 
	</form><br>
	Not a User ?
	<a href="SignupEcommerce.jsp" style="color: blue">Sign Up</a>
</body>
</html>