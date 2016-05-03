<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dargenn
  Date: 5/1/16
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Succeded!</title>
    <link href="http://fonts.googleapis.com/css?family=Didact+Gothic" rel="stylesheet" />
    <link href="<c:url value='/static/css/default.css' />" rel="stylesheet" type="text/css" media="all" />
    <link href="<c:url value='/static/css/fonts.css' />" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div id="welcome">
    <div class="container">
        <div class="title">
            <h1>User ${login} just registered!</h1>
            <span class="byline">Go back to the login page:</span>
        </div>
        <ul class="actions">
            <li><a href="/" class="button">HOME</a></li>
        </ul>
    </div>
</div>

<%@ include file="footer.jsp" %>
