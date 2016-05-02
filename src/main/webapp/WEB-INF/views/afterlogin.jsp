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
    <link rel="stylesheet" href="<c:url value='http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css' />" />
    <script src="<c:url value='http://code.jquery.com/jquery-1.11.3.min.js' />"></script>
    <script src="<c:url value='http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js' />"></script>
</head>
<body>
<div data-role="header">
    <h1>Hello ${login}!</h1>
</div>

<div id="excercise">
    <h1>Excercises</h1>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Sets</th>
            <th>Reps</th>
            <th>Weight</th>
            <th>Date</th>
        </tr>
        <c:forEach items="${excercises}" var="ex">
            <tr>
                <td>${ex.id}</td>
                <td>${ex.name}</td>
                <td>${ex.sets}</td>
                <td>${ex.reps}</td>
                <td>${ex.weight}</td>
                <td>${ex.excerciseDate}</td>
                <td><a href="#myPopup" data-rel="popup" target="_blank" class="ui-btn ui-btn-inline ui-corner-all ui-icon-check ui-btn-icon-left">Edit</a></td>
                <div data-role="popup" id="myPopup" class="ui-content" style="min-width:250px;">
                    <form method="post" action="/edit-${ex.id}-excercise">
                        <br /><label for="eeid">ID:</label>
                        <input type="text" id="eeid" name="eeid" readonly="readonly"/>
                        <br /><label for="eexname">Excercise:</label>
                        <input type="text" id="eexname" name="eexname" />
                        <br /><label for="eexsets">Sets:</label>
                        <input type="text" id="eexsets" name="eexsets" />
                        <br /><label for="eexreps">Reps:</label>
                        <input type="text" id="eexreps" name="eexreps" />
                        <br /><label for="eexweight">Weight:</label>
                        <input type="text" id="eexweight" name="eexweight" />
                        <br /><input type="submit" value="Edit excercise" />
                    </form>
                </div>
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

<div data-role="footer">
    <h1>Projekt Silownia - Programowanie Aplikacji WWW w technologii Java</h1>
</div>
</body>
</html>
