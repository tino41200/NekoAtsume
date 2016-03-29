<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Home page</title>
        <style>
            #home-box {
                width: 300px;
                padding: 20px;
                margin: 100px auto;
                background: #fff;
                -webkit-border-radius: 2px;
                -moz-border-radius: 2px;
                border: 1px solid #000;
            }
        </style>
    </head>
    <body>
        <h1>Home page</h1>
        <div id="home-box">
            <p>This is Home page. It's available for all users.<br/>
                <a href="${pageContext.request.contextPath}/moderation.html">Moderation page</a><br/>
                <a href="${pageContext.request.contextPath}/newuser.html">Create user</a> <br/>
                <a href="${pageContext.request.contextPath}/admin/first.html">First Admin page</a><br/>
                <a href="${pageContext.request.contextPath}/admin/second.html">Second Admin page</a><br/>

            </p>
        </div>

    </body>
</html>