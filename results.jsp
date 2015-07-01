<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.unsw.comp9321.*"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<jsp:useBean id="searchList" class="edu.unsw.comp9321.SearchListBean" scope="session"/>
<jsp:useBean id="order" class="edu.unsw.comp9321.OrderBean" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
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

	<h2 align="center">Search Results: </h2>
		
	<table align="center" border="1" width="800">
		<tr>
			<th>Title</th>
		</tr>
		<c:choose>
			<c:when test="${isEmptySearch eq true}">
				<tr>
					<td><h4>No search terms provided.</h4></td>
				</tr>
			</c:when>
			<c:otherwise>
			
				<c:choose>
					<c:when test="${resultSize > 0}">
						<c:forEach var="result" items="${searchList.searchList}" begin="${pageNumber * 10}" end="${((pageNumber + 1) * 10) - 1}" >
							<tr>
								<td>
									<form action="ControlServlet" method="GET">
										<input type="hidden" name="action" value="info">
										<input type="hidden" name="id" value="${result.id}">
										<input type="submit" value="${result.title}">
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td><h4>Sorry, no matching datasets found!</h4></td>
						</tr>
					</c:otherwise>
				</c:choose>
			
			</c:otherwise>
		</c:choose>
		
	</table>
	
	<c:choose>
		<c:when test="${isEmptySearch eq true}">
		</c:when>
		<c:otherwise>
			<c:if test="${pageNumber > 0}">
				<form method="GET" action="ControlServlet">
					<input type="hidden" name="action" value="previousPage"/>
					<input type="submit" value="Previous Page"/>
				</form>
			</c:if>
		</c:otherwise>	
	</c:choose>

	<c:if test="${resultSize - 10 > 0}">
		<form method="GET" action="ControlServlet">
			<input type="hidden" name="action" value="nextPage"/>
			<input type="submit" value="Next Page"/>
		</form>
	</c:if>
	
	<form method="GET" action="ControlServlet">
		<input type="hidden" name="action" value="welcome"/>
		<input type="submit" value="Back To Search"/>
	</form>
</body>
</html>