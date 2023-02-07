<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
%>
<%@page import="dao.ProductDao" 
	import = "java.util.ArrayList"
	import = "bean.ProductBean"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin-Ecommerce</title>

<style type="text/css">
	
        table {
            border-collapse: collapse;
            text-align: center;
        }

        td,th {
            padding: 10px;
        }
        
        input{
        	margin:5px;
        }
    
</style>
</head>
<body>
	<h2>Admin Side ------ Ecommerce Website</h2>
	
	<table border=1>
        <tr>
            <th>Product Id</th>
            <th>Product Name</th>
            <th>Available Qty</th>
            <th>Price</th>
            <th>Image</th>
            <th>Edit Options</th>
        </tr>
        <%
        	//get all Product List here -->then go for display
        	ProductDao pdao = ProductDao.getInstance();
        	ProductBean pbean=null;
        	ArrayList<ProductBean> allProducts = pdao.getAllProducts();
        	for(int i=0;i<allProducts.size();i++)
        	{
        		pbean = allProducts.get(i);
        		
        %>
        <tr>
            <td>
            	<%=pbean.getProduct_id()%>
            </td>
            <td><%=pbean.getProductName()%></td>
            <td><%=pbean.getProductQty() %></td>
            <td><%=pbean.getProductPrice() %></td>
            <td><%=pbean.getImgurl() %></td>
            <td>
            	<form action="AdminEcommerceServlet" method="post">
            		<input type="hidden" value="<%=pbean.getProduct_id()%>" name="deleteProduct">
                	<input type="submit" value="Delete">
                </form>
                <form action="UpdateProductEcommerce.jsp" method="post">
                    <input type="hidden" value="<%=pbean.getProduct_id()%>" name="updateProduct">
                    <input type="hidden" value="<%=pbean.getProductName()%>" name="productName" >
                    <input type="hidden" value="<%=pbean.getProductPrice()%>" name="productPrice">
                    <input type="hidden" value="<%=pbean.getProductQty()%>" name="productQty" >
                    <input type="hidden" value="<%=pbean.getImgurl()%>" name="productpath" >
                	<input type="submit" value="Update" >
                </form>
            </td>
        </tr>
        <%
        	}
        %>
    </table>
    <button style="margin:20px;font-size: 1rem;">
        <a href="AddProductEcommerce.jsp"> Add a Product </a>
    </button>
		
</body>
</html>