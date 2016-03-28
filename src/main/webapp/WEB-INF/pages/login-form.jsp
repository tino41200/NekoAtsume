<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html dir="ltr" lang="en-US"><head><!-- Created by Artisteer v4.1.0.59861 -->
    <meta charset="utf-8">
    <title>Nouvelle Page</title>
    <meta name="viewport" content="initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no, width = device-width">
    
    <!--[if lt IE 9]><script src="https://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <link rel="stylesheet" href="/resource/style/style.css" media="screen">
    <!--[if lte IE 7]><link rel="stylesheet" href="style.ie7.css" media="screen" /><![endif]-->
    <link rel="stylesheet" href="/resource/style/style.responsive.css" media="all">


    <script src="/resource/style/jquery.js"></script>
    <script src="/resource/style/script.js"></script>
    <script src="/resource/style/script.responsive.js"></script>


</head>
<body>
<div id="main">
<header class="header">


    <div class="shapes">

            </div> 
</header>
<<<<<<< HEAD
    
<div class="sheet clearfix">
            <div class="layout-wrapper">
                <div class="content-layout">
                    <div class="content-layout-row">
                        <div class="layout-cell content"><div class="block clearfix">
        <div class="blockheader">
            <h3 class="t">Connexion</h3>
        </div>
        <div class="blockcontent"><form method="post" action="<c:url value='j_spring_security_check'/>" >
  <fieldset class="input" style="border: 0 none;">
	
		<p>
				<c:if test="${error == true}">
				<div class="error">Invalid login or password.</div>
				</c:if>
			</p>

			
				<table>
				<tbody>
				<tr>
				<c:choose>
					<c:when test="${log}">
						<td>Login:</td>
						<td><input type="text" name="j_username" id="j_username"size="30" maxlength="40"  
								   value = "${userLog1}"/></td>
					</c:when>
					<c:otherwise>
						<td>Login:</td>
						<td><input type="text" name="j_username" id="j_username"size="30" maxlength="40" /></td>
					</c:otherwise>
				</c:choose>
				</tr>
				<tr>
				
				<c:choose>
					<c:when test="${log}">
						<td>Password:</td>
						<td><input type="password" name="j_password" id="j_password" size="30" maxlength="32" value = "${userLog2}"/></td>
					</c:when>
					<c:otherwise>
						<td>Password:</td>
						<td><input type="password" name="j_password" id="j_password" size="30" maxlength="32" /></td>
					</c:otherwise>
				</c:choose>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login" /></td>
				</tr>
				</tbody>
				</table>
			</form>	
		
	<!--	
    <p id="form-login-username">
      <label for="modlgn_username">Pseudo</label>
      <br />
      <input id="modlgn_username" type="text" name="username" class="inputbox" alt="username" style="width:50%" />
    </p>
    <p id="form-login-password">
      <label for="modlgn_passwd">Mot de passe</label>
      <br />
      <input id="modlgn_passwd" type="password" name="passwd" class="inputbox" size="18" alt="password" style="width:50%" />
    </p>
	<br />
    <input type="submit" value="Login" name="Submit" class="button" />    
  </fieldset> -->
  <ul>
<!--    <li>
      <a href="#">Mot de passe oublié ?</a>
    </li>-->
    <li>
      <a href="/newuser">Créer un compte ?</a>
=======
<div class="sheet clearfix">
            <div class="layout-wrapper">
                <div class="content-layout">
                    <div class="content-layout-row">
                        <div class="layout-cell content"><div class="block clearfix">
        <div class="blockheader">
            <h3 class="t">Connexion</h3>
        </div>
        <div class="blockcontent"><form method="post" action="<c:url value='j_spring_security_check'/>" >
  <fieldset class="input" style="border: 0 none;">
	
		<p>
				<c:if test="${error == true}">
				<div class="error">Invalid login or password.</div>
				</c:if>
			</p>

			
				<table>
				<tbody>
				<tr>
				<c:choose>
					<c:when test="${log}">
						<td>Login:</td>
						<td><input type="text" name="j_username" id="j_username"size="30" maxlength="40"  
								   value = "${userLog1}"/></td>
					</c:when>
					<c:otherwise>
						<td>Login:</td>
						<td><input type="text" name="j_username" id="j_username"size="30" maxlength="40" /></td>
					</c:otherwise>
				</c:choose>
				</tr>
				<tr>
				
				<c:choose>
					<c:when test="${log}">
						<td>Password:</td>
						<td><input type="password" name="j_password" id="j_password" size="30" maxlength="32" value = "${userLog2}"/></td>
					</c:when>
					<c:otherwise>
						<td>Password:</td>
						<td><input type="password" name="j_password" id="j_password" size="30" maxlength="32" /></td>
					</c:otherwise>
				</c:choose>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login" /></td>
				</tr>
				</tbody>
				</table>
			</form>	
		
	<!--	
    <p id="form-login-username">
      <label for="modlgn_username">Pseudo</label>
      <br />
      <input id="modlgn_username" type="text" name="username" class="inputbox" alt="username" style="width:50%" />
    </p>
    <p id="form-login-password">
      <label for="modlgn_passwd">Mot de passe</label>
      <br />
      <input id="modlgn_passwd" type="password" name="passwd" class="inputbox" size="18" alt="password" style="width:50%" />
    </p>
	<br />
    <input type="submit" value="Login" name="Submit" class="button" />    
  </fieldset> -->
  <ul>
    <li>
      <a href="#">Mot de passe oublié ?</a>
    </li>
    <li>
      <a href="#">Créer un compte ?</a>
>>>>>>> origin/master
    </li>
  </ul>
</form></div>
</div>
</div>
                       
                    </div>
                </div>
            </div>
    </div>
<footer class="footer">
  <div class="footer-inner">

    <p class="page-footer">
        <span id="footnote-links">Developpé par : Diamantino - Gaël - Iandry - Kévin.</span>
    </p>
  </div>
</footer>

</div>


</body></html>
