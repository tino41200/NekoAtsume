<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr" lang="en-US"><head>
        <meta charset="utf-8">
        <title>Admin - Users</title>
        <meta name="viewport" content="initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no, width = device-width">

        <!--[if lt IE 9]><script src="https://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
        <link rel="stylesheet" href="/resource/style/style.css" media="screen">
        <!--[if lte IE 7]><link rel="stylesheet" href="style.ie7.css" media="screen" /><![endif]-->
        <link rel="stylesheet" href="/resource/style/style.responsive.css" media="all">


        <script src="/resource/style/jquery.js"></script>
        <script src="/resource/style/script.js"></script>
        <script src="/resource/style/script.responsive.js"></script>



        <style>.content .postcontent-0 .layout-item-0 { padding-right: 10px;padding-left: 10px;  }
            .ie7 .post .layout-cell {border:none !important; padding:0 !important; }
            .ie6 .post .layout-cell {border:none !important; padding:0 !important; }

        </style></head>
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
                            <div class="layout-cell content">
                                <article class="post article">
                                    <div class="postmetadataheader">
                                        <a href="${pageContext.request.contextPath}/admin.html">Admin page</a><br/><br/>
                                        <table style="border: 1px solid; width: 100%; text-align:center">
                                            <thead style = "background:#d3dce3">
                                                <tr>
                                                    <th>id_user</th>
                                                    <th>Login</th>
                                                    <th>Password</th>
                                                </tr>
                                            </thead>
                                            <tbody style="background:#ccc">
                                                <c:forEach items="${listuser}" var="liste">

                                                    <tr>
                                                        <td><c:out value="${liste.id}"/></td>
                                                        <td><c:out value="${liste.login }"/></td>
                                                        <td><c:out value="${liste.password }"/></td>
                                                        <td><a href = "/supprimer-${liste.id}">Bannir</a></td>
                                                    </tr>
                                                </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                </article>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

    </body>
    <footer class="footer">
        <div class="footer-inner">

            <p class="page-footer">
                <span id="footnote-links">Developp� par : Diamantino - Ga�l - Iandry - K�vin.</span>
            </p>
        </div>
    </footer>
</div>
</body>
</html>

