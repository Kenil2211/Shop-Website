<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String pname = request.getParameter("productName");
	String price = request.getParameter("productPrice");
	String pqty = request.getParameter("productQty");
	String path = request.getParameter("productpath");
%>
<body>
	<h2>Update Product Page</h2>
	
	
	<form method="post" action="AdminEcommerceServlet">
	
		Product Name: <input type="text" name="pname" 
		value="<%=pname==null?"":pname %>" >
		<br><br>
		Product Price: <input type="text" name="price" 
		value = "<%=price==null?"":price %>">
		<br><br>
		Available Quantity: <input type="text" name="qty"
		value = "<%=pqty==null?"":pqty %>">
		<br><br>
		Image Path : <input type="text" name="imgurl" placeholder="/image/"
		value = "<%=path==null?"":path %>">
		<br><br>
		
		<input type="hidden" value="<%=request.getParameter("updateProduct")%>" name="keyupdateProduct">
		
		<input type="submit" value="Update Product"><br>	
	</form>
</body>
</html>