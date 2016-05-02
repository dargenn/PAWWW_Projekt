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
    <link rel="stylesheet" href="<c:url value='/static/css/app.css' />" />
</head>
<body>
    <h1>User ${login}just registered!</h1>
    <h2>Go back to the login page: <a href="index.jsp"><h1>HOME</h1></a></h2>
</body>
</html>
