<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.unsw.comp9321.*"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="order" class="edu.unsw.comp9321.OrderBean" scope="session"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
</head>
<body>

	<h1>Your Shopping Cart</h1>
	
	<form method="POST" action="ControlServlet">
		<table border="1" width="800px" align="center">
			<tr>
				<th>Title</th>
			</tr>
			<c:choose>
				<c:when test="${isCartEmpty eq 'false'}">
					<c:forEach var="dataset" items="${order.orders}">
						<tr>
							<td><c:out value="${dataset.title}"/></td>
							<td width="20"><input type="checkbox" name="resultChecked" value="${dataset.title}"/></td>
						</tr>
					</c:forEach>	
					<tr>
						<td><input type="hidden" name="action" value="remove"/></td>
						<td><input type="submit" value="Remove from Cart"/></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td><h4>Shopping Cart is Empty!</h4></td>
					</tr>
				</c:otherwise>	
			</c:choose>
		</table>
	</form>
	
	<form method="GET" action="ControlServlet">
		<input type="hidden" name="action" value="welcome"/>
		<input type="submit" value="Back To Search"/>
	</form>
</body>
</html>