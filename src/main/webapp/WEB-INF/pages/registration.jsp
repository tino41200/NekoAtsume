<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Info</title>
</head>
<body>

<h1>User Info</h1> 

<c:url var="saveUrl" value="/newuser" />
<form:form modelAttribute="user" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="login">Login:</form:label></td>
			<td><form:input type="text" path="login" name="newlogin"/></td>
		</tr>

		<tr>
			<td><form:label path="password">password</form:label></td>
			<td><form:input type="password" path="password" name="newpassword"/></td>
		</tr>
		
		
		
	</table>
	
	<input type="submit" value="Save" />
</form:form>

</body>
</html>