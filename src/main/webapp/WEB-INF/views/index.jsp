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
    <link rel="stylesheet" href="<c:url value='/static/css/app.css' />" />
</head>
<body>

<div id="loginContainer">
    <h1>PLEASE LOGIN</h1>
    <form method="post" action="/login">
        <label for="login">Login:</label>
        <input type="text" id="login" name="login"/>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" />
        <input type="submit" value="Login" />
    </form>
</div>

<div id="registerContainer">
    <h1>PLEASE REGISTER</h1>
    <form method="post" action="/register">
        <label for="login">Login:</label>
        <input type="text" id="reglogin" name="reglogin"/>
        <label for="password">Password:</label>
        <input type="password" id="regpassword" name="regpassword" />
        <input type="radio" />
        <input type="submit" value="Register!" />
    </form>
</div>

    <h1>Hello world</h1>
    <h2>List of Users - now we have ${userCount} of them!</h2>
    <table>
        <tr>
            <th>Login</th>
            <th>Password</th>
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
