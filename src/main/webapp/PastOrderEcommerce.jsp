<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.OrderDao"
		 import="java.util.ArrayList"
		 import="bean.OrderHistoryBean"

%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		border-collapse: collapse;	
	}
	a{
		color:yellow
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
    }
    
    
    td,th{
		padding:20px;
		text-align: center;
	} 
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
            <div class="navbar" ><a href="#" style="font-size:30px;margin-left:30px">Past Orders</a></div>
            <div class="navbar" ><a href="HomeEcommerce.jsp?sdfg=ylo" style="font-size:25px;margin-left:10px">Log Out</a></div>
     </div>
<h1 align="center">Your Orders</h1>
<%
	ArrayList<OrderHistoryBean> list=new ArrayList<OrderHistoryBean>();
	OrderDao odao=OrderDao.getInstance();
	list = odao.getOrderHistory(uid);
	
	OrderHistoryBean ohbean = null;
	
	if(list.size() != 0)
	{
		
	
%>
	
	<table border=1 align="center" >
		<tr>
			<th>Order Id</th>
			<th>Order Date</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Quantity</th>
			<th>Total</th>
		</tr>
	<%
		for(int i=0;i<list.size();i++)
		{
			
			ohbean = list.get(i);
	%>
	<tr>
			<td><%=ohbean.getOid()%></td>
			<td><%=ohbean.getOrderdate()%></td>
			<td><%=ohbean.getPname()%></td>
			<td><%=ohbean.getPrice()%></td>
			<td><%=ohbean.getQty()%></td>
			<td><%=Integer.parseInt(ohbean.getPrice()) *  Integer.parseInt(ohbean.getQty())  %>
			</td>
		</tr>
			
	<%
		}
	%>
</table>
<%
	}else{
		
%>
<p> You have not Ordered Till Date...</p>
<%
	}	
%>













</body>
</html>