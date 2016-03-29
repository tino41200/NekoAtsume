<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>title</title>
    </head>
    <body>

        <h1>Message : ${message}</h1> 

        <c:if test="${pageContext.request.userPrincipal.name != null }"> 
            <p>This is Moderation page. It's available for moderators. Like you mr ${pageContext.request.userPrincipal.name}</p><br/>
            <a href="<c:url value="/j_spring_security_logout" />" >Logout</a> <br/>
            <a href="${pageContext.request.contextPath}/edituser-${pageContext.request.userPrincipal.name}">Edit compte</a> <br/>
            <a href="<c:url value="/liste.html" />">Voir liste chat</a>
        </c:if>

    </body>
</html>