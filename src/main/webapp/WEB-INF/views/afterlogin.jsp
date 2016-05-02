<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dargenn
  Date: 5/1/16
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>After Login Page</title>
    <link rel="stylesheet" href="<c:url value='/static/css/app.css' />" />
</head>
<body>
    <h1>Hello ${login}!, your password is: ${password} and id: ${currentId}</h1>
<div id="excercise">
    <h1>Excercises</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Sets</th>
            <th>Reps</th>
            <th>Weight</th>
            <th>Date</th>
        </tr>
        <c:forEach items="${excercises}" var="ex">
            <tr>
                <td>${ex.name}</td>
                <td>${ex.sets}</td>
                <td>${ex.reps}</td>
                <td>${ex.weight}</td>
                <td>${ex.excerciseDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
