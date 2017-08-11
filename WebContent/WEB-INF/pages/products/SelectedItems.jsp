<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styless.css"> 
</head>
<body>
	
		<sql:setDataSource var="db" url="jdbc:mysql://localhost:3306/User" driver="com.mysql.jdbc.Driver"
			user="root" password=""   />
		<c:set var="total" value="0"/>
		<table align="center" border="2">
			<tr>
				<th>Product Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach var="Product" items="${Product}">
				<sql:query var="rs" dataSource="${db}">
					Select * from products where Name=?;
					<sql:param value="${Product}" /> 
				</sql:query>
			
				<c:forEach var="table" items="${rs.rows}">
					<tr>
						<td><c:out value="${table.product_Id}"/></td>  
						<td><c:out value="${table.Name}"/></td>  
						<td><c:out value="${table.Price}"/></td>
						<td><c:out value="${table.Quantity}"/></td>
					<c:set var="total" value="${total+table.Price}"/> 
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<h2 align="center">Total Price <c:out value="${total}"></c:out></h2>
</body>
</html>