<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr" lang="en-US"><head>
    <meta charset="utf-8">
    <title>Liste des chats</title>
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
                        <div class="layout-cell content">
                            <article class="post article">
                                <div class="postmetadataheader">
      <form action="chats" method="post">
          <br>
          <h3>Rechercher :</h3><br><input type="text" name="searchText" /><br/>
<br>
      <input type="submit" value="Search"/>
            <br>        
                </form>
                    <br>
                                        </div>                                        
                                        <br><br>
                                <div class="postmetadataheader">
                                        <h2 class="postheader">Liste des chats</h2>
      
                                        
                                        <
      <table style="border: 1px solid; width: 100%; text-align:center">
		<thead style = "background:#d3dce3">
			<tr>
				<th colspan="1">Photo</th>
				<th>id_chat</th>
				<th>Nom</th>
				<th>Nom Japonais</th>
				<th>Description</th>
				<th>Personnalite</th>
				<th>Niveau</th>
			</tr>
                            </thead>
                            <tbody style="background:#ccc">
                    <c:choose>
			<c:when test="${find}">
			<c:url var="ImgUrl" value="/resource/img/${listechat.nom}.png" />
                        <tr>
                            <td><a href="${ImgUrl}"><img src="${ImgUrl}"></img></a></td>
					<td><c:out value="${listechat.idChat}"/></td>
                                        <td><a href="${listechat.nom}"><c:out value="${listechat.nom }"/></a></td>
                                        <td><c:out value="${listechat.nomJaponais }"/></td>
                                        <td><c:out value="${listechat.description }"/></td>
					<td><c:out value="${listechat.personnalite }"/></td>
					<td><c:out value="${listechat.niveau }"/></td>
<!--					<td><a href="/astuce-${liste.nom}">Astuce</a></td>-->
				</tr>
			</c:when>
			<c:otherwise>
			<c:forEach items="${listechat}" var="liste">
			<c:url var="ImgUrl" value="/resource/img/${liste.nom}.png" />
				<tr>
					<td><a href="${ImgUrl}"><img src="${ImgUrl}"></img></a></td>
					<td><c:out value="${liste.idChat}"/></td>
                                        <td><a href="${liste.nom}"><c:out value="${liste.nom }"/></a></td>
                                        <td><c:out value="${liste.nomJaponais }"/></td>
                                        <td><c:out value="${liste.description }"/></td>
					<td><c:out value="${liste.personnalite }"/></td>
					<td><c:out value="${liste.niveau }"/></td>
<!--					<td><a href="/astuce-${liste.nom}">Astuce</a></td>-->
				</tr>
			</c:forEach>
			</c:otherwise>
                                </c:choose>
                                <c:choose>
					<c:when test="${astuce}">
					<c:url var="ImgUrl" value="/resource/img/${chat.nom}.png" />
					<td><a href="${ImgUrl}"><img src="${ImgUrl}"></img></a></td>
					<td><c:out value="${chat.idChat}"/></td>
					<td><c:out value="${chat.nom }"/></td>
					<td><c:out value="${chat.nomJaponais }"/></td>
					<td><c:out value="${chat.description }"/></td>
					<td><c:out value="${chat.personnalite }"/></td>
					<td><c:out value="${chat.niveau }"/></td>
				
				
                                    </c:when>
				</c:choose> 
                            </tbody>
                            
                                </table>
                                <c:choose>
					<c:when test="${find}">
					
					<a href="<c:url value="/chats" />">Voir liste chat</a>
					</c:when>
				</c:choose> 
				
				<!-- ****************************ESSAYER AJOUT ASTUCE -->
				
				<c:choose>
					<c:when test="${astuce}">
					
					<a href="<c:url value="/chats" />">Voir liste chat</a> <br />
					</c:when>
				</c:choose> 
				
				       
                                    </div>
                                <br><br><br><br>
                                <div class="postmetadataheader">
                                    <form action="astuce" method="post">
				<c:choose>
					
					<c:when test="${astuce}">
					<tr>
<!--					<td><a href="${ImgUrl}"><img src="${ImgUrl}"></img></a></td> <br />
					<th><c:out value="${chat.nom}"/></th><br />-->
                                        <h2 class="postheader">Ajouter un commentaire sur ce chat :</h2>
                                        <br>
					<th><c:out value="${pageContext.request.userPrincipal.name}"/></th><br />
                                        <textarea class="input-AjoutAstuce" type="text" name="ajoutAstuce"></textarea><br/>
                                        <br>
     					 <input type="submit" value="Ajouter astuce"/> 
                                         <br><br>
				</tr>
					</c:when>
				</c:choose> 
				</form>
                                  <!-- *************************FIN AJOUT ASTUCE -->

                                </div>
                                <div class="postcontent postcontent-0 clearfix"><p><br></p></div>


</article></div>
                        
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