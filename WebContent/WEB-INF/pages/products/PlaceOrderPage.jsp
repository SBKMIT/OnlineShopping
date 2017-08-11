<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		<h1>Your Cart products</h1>
	</center>
	<table align="center" bordercolor="brown" cellpadding="2"
		cellspacing="2" border="3">
		<thead>
			<tr>
				<th>Product Name</th>
				<th>Description</th>
				<th>Prize</th>
			<tr>
		</thead>
		<tbody>
			<c:forEach items="${cartList}" var="p">

				<tr>
					<td>${p.productBean.productName}</td>
					<td>${p.productBean.description}</td>
					<td>${p.productBean.price}</td>
				</tr>
			</c:forEach>
			<tr>
				<td>Total Prize</td>
				<td></td>
				<td>${totalPrize}</td>
			</tr>
		</tbody>

	</table>
</body>
</html>