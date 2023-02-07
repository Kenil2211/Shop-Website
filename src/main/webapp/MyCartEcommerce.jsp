<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "dao.CartDao"
		 import= "bean.CartBean" 
		 import="java.util.ArrayList"
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ecommerce Cart</title>
<style type="text/css">
	table{
		border-collapse: collapse;
	}
	td,th{
		padding:20px;
		text-align: center;
	}
	.order-btn{
		padding:20px;
	}
	a{
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
            <div class="navbar" id="btn1"><a href="HomeEcommerce.jsp" style="font-size:30px;">Home</a></div>
            <div class="navbar" ><a href="#" style="font-size:30px;margin-left:30px">Hello, <%=uname==null?"User":uname%></a></div>
            <div class="navbar" ><a href="MyCartEcommerce.jsp" style="font-size:30px;margin-left:30px">Cart</a></div>
            <div class="navbar" ><a href="OrderEcommerce.jsp" style="font-size:30px;margin-left:30px">My Order</a></div>
            <div class="navbar" ><a href="PastOrderEcommerce.jsp" style="font-size:30px;margin-left:30px">Past Orders</a></div>
            <div class="navbar" ><a href="#" style="font-size:25px;margin-left:10px">Log Out</a></div>
     </div>
     
	<h1 align="center">My Cart</h1>
	
	<%
		CartBean cbean=null;
		ArrayList<CartBean> l =new ArrayList<CartBean>();
		
		CartDao cdao=CartDao.getInstance();
		l=cdao.getCart(uid);
		if(l.size() > 0)
		{
	%>
	
	<form action="CartEcommerceServlet" method="post">
	<table border=1 align="center" >
		<tr>
			<th>Product Name</th>
			<th>Product Price</th>
			<th> Quantity</th>
			<th>Remove</th>
		</tr>
	<%
		//------------------
		
		for(int i=0;i<l.size();i++)
		{
			cbean = l.get(i);
			
			
	%>
		<tr>
			<input type="hidden" value="<%=cbean.getCid()%>" name="cart_id">
			<td><%=cbean.getPname()%></td>
			<td><%=cbean.getPrice() %></td>
			<td> <input type="number" value="<%=cbean.getQty()%>" min="0" style="width:2rem" name="qty"></td>
			<td>
				<form action="TempCartServlet" method="post">
					<input type="hidden" value="<%=cbean.getPid()%>" name="pidRemove">
					<input type="hidden" value="<%=cbean.getUid()%>" name="uidRemove">
					<input type="hidden" value="remove" name="keyforremove">
					<input type="submit" value="Remove from Cart">
				</form>
			</td>
		</tr>
	<%
		}
	%>
	
	<tr>
		<td colspan=4 align="center">
				<input type="hidden" value="goforupdate" name="key">
				<input type="submit" value="Proceed to Buy" style="margin:5px" class="order-btn">
		</td>
	</tr>
	</table>
	</form>
	<%
		}
		else
		{
	%>
		<p align="center"> Your CART is empty..add some products..
	<%
		}
	%>
	













</body>
</html>