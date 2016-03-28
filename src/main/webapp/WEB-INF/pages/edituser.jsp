<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html dir="ltr" lang="en-US"><head><!-- Created by Artisteer v4.1.0.59861 -->
    <meta charset="utf-8">
    <title>Profil</title>
    <meta name="viewport" content="initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no, width = device-width">
    
    <!--[if lt IE 9]><script src="https://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <link rel="stylesheet" href="/resource/style/style.css" media="screen">
    <!--[if lte IE 7]><link rel="stylesheet" href="style.ie7.css" media="screen" /><![endif]-->
    <link rel="stylesheet" href="/resource/style/style.responsive.css" media="all">


    <script src="/resource/style/jquery.js"></script>
    <script src="/resource/style/script.js"></script>
    <script src="/resource/style/script.responsive.js"></script>
<body>
    <div id="main">
<header class="header">


    <div class="shapes">

            </div> 
</header>
        <nav class="nav">
    <ul class="hmenu"><li><a href="accueil.html" class="active">Accueil</a></li>
    					  <li><a href="chats">Chats</a><ul><li><a href="chats/rare.html">Rares</a></li>
    					  <li><a href="chats/communs">Communs</a></li></ul></li>
    					  <li><a href="astuces">Astuces</a></li>  
    					  <li><a href="${pageContext.request.contextPath}/edituser-${pageContext.request.userPrincipal.name}">Edit compte : ${pageContext.request.userPrincipal.name}</a></li>
    					  <li><a href="<c:url value="/j_spring_security_logout" />" >Logout</a></li>
    </nav>
<div class="sheet clearfix">
            <div class="layout-wrapper">
                <div class="content-layout">
                    <div class="content-layout-row">
                        <div class="layout-cell content"><div class="block clearfix">
<<<<<<< HEAD
                                
        <div class="blockheader">
            <h1 class="t">Profil - Edit Profil</h1>
=======
        <div class="blockheader">
            <h1>Profil - Edit Profil</h1>
>>>>>>> origin/master
            <h2>${pageContext.request.userPrincipal.name}</h2>
        </div>

 

<c:url var="saveUrl" value="/edituser-${user.login}" />
<form:form modelAttribute="user" method="POST" action="${saveUrl}">
 <table>
	<tr>
   <td><form:label path="id">Id:</form:label></td>
   <td><form:input path="id" disabled="true"/></td>
  </tr>
  
  
  <tr>
  	
   <td><form:label path="login">Login:</form:label></td>
   <td><form:input path="login"/></td>
  
  </tr>
  
   
  <tr>
   <td><form:label path="Password">Password:</form:label></td>
   <td><form:input path="Password"/></td>
  </tr>
   
 
 </table>
  
 <input type="submit" value="Save" />
</form:form>
 </div>
</div>
</div>
                       
                    </div>
                </div>
            </div>
    </div>
 
</body>
<footer class="footer">
  <div class="footer-inner">

    <p class="page-footer">
        <span id="footnote-links">Developpé par : Diamantino - Gaël - Iandry - Kévin.</span>
    </p>
  </div>
</footer>
</html>
 
