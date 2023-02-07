
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Add Product Page</h2>
	
	<form method="post" action="AdminEcommerceServlet">
	
		Product Name: <input type="text" name="pname">
		<br><br>
		Product Price: <input type="text" name="price">
		<br><br>
		Available Quantity: <input type="text" name="qty">
		<br><br>
		Image Path : <input type="text" name="imgurl" placeholder="/image/"><br><br>
		
		<input type="hidden" value="addnewProduct" name="keyAddProduct">
		<input type="submit" value="Add Product"><br>	
	</form>
</body>
</html>