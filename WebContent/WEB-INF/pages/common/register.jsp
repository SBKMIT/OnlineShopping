<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<style>
.error {
	color: red;
	font-weight: small;
}
</style>


</head>
<body style="background-color:">



	<h1 align="center" style="color: brown">Registration Form</h1>
	<h3 align="center" style="color: blue">
		<a href="loginForm">Login</a>
	</h3>

	<form:form method="POST" action="saveRegister"
		modelAttribute="userBean">
		<table align="center" cellpadding="1" cellspacing="2"
			bordercolor="brown" border="2">
			<tr>
				<td>User Name</td>
				<td><form:input path="userName" />
					<form:errors path="userName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td><form:input path="emailId" />
					<form:errors path="emailId" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address" />
					<form:errors path="address" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><form:input path="mobileNumber" />
					<form:errors path="mobileNumber" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><form:input path="password" type="password" />
					<form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><form:input path="confirmPassword" type="password" />
					<form:errors path="confirmPassword" cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="Submit" /></td>

			</tr>
		</table>
	</form:form>
</body>
</html>