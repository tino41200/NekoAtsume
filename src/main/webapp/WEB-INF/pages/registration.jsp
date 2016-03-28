<<<<<<< HEAD
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
<div class="sheet clearfix">
            <div class="layout-wrapper">
                <div class="content-layout">
                    <div class="content-layout-row">
                        <div class="layout-cell content"><div class="block clearfix">
                                <div class="blockheader">
            <h3 class="t">Inscription</h3>
        </div>
       <c:url var="saveUrl" value="/newuser" />
<form:form modelAttribute="user" method="POST" action="${saveUrl}">
    
	<table>
		<tr>
			<td><form:label path="login">Login:</form:label><span class="requis">*</span></td>
                        <td><form:input id="login" path="login" name="newlogin" onkeypress="verifierCaracteres(event);return false;"/></td>
                        <h2><span class="erreur" id="erreurSaisie" style="color: red"></span></h2>
		</tr>

		<tr>
			<td><form:label path="password">password</form:label><span class="requis">*</span></td>
                        <td><form:input id="password" path="password" name="newpassword" onkeypress="verifierCaracteres(event); return false;"/></td>
                        <h2><span class="erreur" id="erreurSaisie" style="color: red"></span></h2>
		</tr>
                
                <tr>
			<td><form:label path="adresse_mail">mail</form:label><span class="requis">*</span></td>
			<td><form:input path="adresse_mail" name="newadresse_mail"/></td>
		</tr>	
         
            </table>
	
	<input type="submit" value="Save" />
</form:form>
        <br />
        <input type="button" value="Retour" onclick="history.go(-1)"</input>
        <script>
            function verifierCaracteres(event) {

            var keyCode = event.which ? event.which : event.keyCode;
            var touche = String.fromCharCode(keyCode);

            var caracteres = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';

            var erreurSaisie = document.getElementById("erreurSaisie");

            if(caracteres.indexOf(touche) >= 0) { 

                    erreurSaisie.innerText = "";
                    champ.value += touche;
            }
            else
            {          
                    erreurSaisie.innerText = "Caractère non autorisé";
            }
        }
</script>
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
 
=======
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
>>>>>>> origin/master
