<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Commerce Website</title>
</head>
<body>
	<h2>SignUp Page</h2>
	<%
		String emailInUse = (String)request.getAttribute("EmailInUse");
		String name  = (String) request.getAttribute("name");
	%>
	
	<form action="SignUpEcommerceServlet" method="post">
		Name     : <input type="text" name="uname" value="<%=name==null?"":name %>"> <br><br>
		Email    : <input type="text" name="uemail"><br><br>
		Password : <input type="text" name="upwd"> <br><br>
			
		<span style="color: red">
		<%=emailInUse==null?"":emailInUse
		%>
		</span><br><br>
		<input type="submit" value="Sign up">
	</form><br><br>
	Already a User ?
	<a href="LoginEcommerce.jsp" style="color: blue">Login</a>
</body>
</html>