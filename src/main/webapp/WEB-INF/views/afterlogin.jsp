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
    <form method="get" action="/addExcercise">
        <br /><label for="exname">Excercise:</label>
        <input type="text" id="exname" name="exname"/>
        <br /><label for="exsets">Sets:</label>
        <input type="text" id="exsets" name="exsets"/>
        <br /><label for="exreps">Reps:</label>
        <input type="text" id="exreps" name="exreps"/>
        <br /><label for="exweight">Weight:</label>
        <input type="text" id="exweight" name="exweight"/>
        <br /><input type="submit" value="Add excercise!" />
    </form>
</div>
</body>
</html>
