<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.unsw.comp9321.*"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<jsp:useBean id="order" class="edu.unsw.comp9321.OrderBean" scope="session"/>
<jsp:useBean id="result" class="edu.unsw.comp9321.ResultBean" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Information</title>
</head>
<body>

   <h1><c:out value="${result.title}"/></h1>

	<form action="ControlServlet" method="POST">
		<table width="800px" align="center">
			<tr>
				<td align="right"><input type="hidden" name="action" value="add"></td>
				<td align="right"><input type="submit" value="Add to Cart"></td>
			</tr>
		</table>
	</form>
	
	<table border="1" width="800px" align="center">
		<tr>
			<th>Contributor</th>
			<td><c:out value="${result.contributor}"/></td>	
		</tr>
		<tr>
			<th>Coverage</th>
			<td><c:out value="${result.coverage}"/></td>	
		</tr>
		<tr>
			<th>Creator</th>
			<td><c:out value="${result.creator}"/></td>	
		</tr>
		<tr>
			<th>Date</th>
			<td><c:out value="${result.date}"/></td>	
		</tr>
		<tr>
			<th>Description</th>
			<td><c:out value="${result.description}"/></td>	
		</tr>
		<tr>
			<th>Format</th>
			<td><c:out value="${result.format}"/></td>	
		</tr>
		<tr>
			<th>Identifier</th>
			<td><c:out value="${result.identifier}"/></td>	
		</tr>
		<tr>
			<th>Language</th>
			<td><c:out value="${result.language}"/></td>	
		</tr>
		<tr>
			<th>Publisher</th>
			<td><c:out value="${result.publisher}"/></td>	
		</tr>
		<tr>
			<th>Relation</th>
			<td><c:out value="${result.relation}"/></td>	
		</tr>
		<tr>
			<th>Rights</th>
			<td><c:out value="${result.rights}"/></td>	
		</tr>
		<tr>
			<th>source</th>
			<td><c:out value="${result.source}"/></td>	
		</tr>
		<tr>
			<th>Subject</th>
			<td><c:out value="${result.subject}"/></td>	
		</tr>
		<tr>
			<th>Type</th>
			<td><c:out value="${result.type}"/></td>	
		</tr>
	</table>

</body>
</html>