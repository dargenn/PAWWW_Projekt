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
    <link rel="stylesheet" href="<c:url value='/css/app.css' />" />
</head>
<body>
    <h1>Hello world</h1>
    <h2>List of Users - now we have ${userCount} of them!</h2>
    <table>
        <tr>
            <td>Login</td>
            <td>Password</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.login}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
