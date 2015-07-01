<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.unsw.comp9321.*"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<jsp:useBean id="searchList" class="edu.unsw.comp9321.SearchListBean" scope="session"/>
<jsp:useBean id="order" class="edu.unsw.comp9321.OrderBean" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Search</title>
	</head>
	<body>
	
		<form action="ControlServlet" method="GET">
			<table width="800px" align="center">
				<tr>
					<td align="right"><input type="hidden" name="action" value="shopCart"></td>
					<td align="right"><input type="submit" value="Shopping Cart"></td>
				</tr>
			</table>
		</form>
		<br>
		<br>

		<form action="ControlServlet" method="GET">
			<table width="200px" align="center">
				<tr>
					<th>Welcome!</th>
				</tr>

				<tr>
					<td><input type="text" name="searchInput" maxlength="50" /></td>
					<td><input type="hidden" name="action" value="searchRequest"/></td>
					<td><input type="submit" value="Search"/></td>
				</tr>
			</table>
		</form>
		
		
	</body>
</html>