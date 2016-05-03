<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dargenn
  Date: 4/26/16
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" href="<c:url value='/static/css/style.css' />"  type="text/css"/>
    <link href="http://fonts.googleapis.com/css?family=Didact+Gothic" rel="stylesheet" />
    <link href="<c:url value='/static/css/default.css' />" rel="stylesheet" type="text/css" media="all" />
    <link href="<c:url value='/static/css/fonts.css' />" rel="stylesheet" type="text/css" media="all" />
</head>
<body>

<div id="welcome">
    <div class="container">
        <h1>Login or Create a Free Account!</h1>
    </div>
    <div class="container">
        <ul class="left-form">
            <h2>New Account:</h2>
            <div>
                <form name="myForm" method="post" action="/register">
                    <li>
                        <input type="text" id="reglogin" name="reglogin" placeholder="Username" required/>
                        <div class="clear"> </div>
                    </li>
                    <li>
                        <input type="password" id="regpassword" name="regpassword" placeholder="password" required/>
                        <div class="clear"> </div>
                    </li>
                    <input type="submit" onclick="myFunction()" value="Register" />
                    <div class="clear"> </div>
                </form>
            </div>
            <div class="clear"> </div>
        </ul>

        <ul class="left-form">
            <h2>Login:</h2>
            <div>
                <form name="myForm" method="post" action="/login">
                    <li>
                        <input type="text" id="login" name="login" placeholder="Login" required/>
                        <div class="clear"> </div>
                    </li>
                    <li>
                        <input type="password" id="password" name="password" placeholder="password" required/>
                        <%--<div class="clear"> </div>--%>
                        <input type="submit" onclick="myFunction()" value="Login"/>
                        <div class="clear"> </div>
                    </li>
                </form>
            </div>
            <div class="clear"> </div>
        </ul>
    </div>
</div>

<%@ include file="footer.jsp" %>