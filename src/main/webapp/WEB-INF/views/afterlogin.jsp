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
    <%--<link rel="stylesheet" href="<c:url value='/static/css/style.css' />"  type="text/css"/>--%>
    <%--<link rel="stylesheet" href="<c:url value='/static/css/app.css' />" />--%>
    <link rel="stylesheet" href="<c:url value='/static/css/afterlogin.css' />" />
    <link rel="stylesheet" href="<c:url value='http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css' />" />
    <script src="<c:url value='http://code.jquery.com/jquery-1.11.3.min.js' />"></script>
    <script src="<c:url value='http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js' />"></script>
</head>
<body style="text-align: center">
<div data-role="header">
    <h1><img src="../../static/images/hand_biceps-256.png" width="50" height="50"/> Hello ${login}!
        <img src="../../static/images/hand_biceps-2562.png" width="50" height="50"/></h1>
</div>
<div id="wrapper">
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
                <td><form action="/delete-${ex.id}-excercise" method="get"><input type="submit" value="DELETE" /></form></td>
            </tr>
        </c:forEach>
    </table>
    <form method="get" action="/addExcercise">
        <br /><label for="exname">Excercise:</label>
        <input type="text" id="exname" name="exname" required/>
        <br /><label for="exsets">Sets:</label>
        <input type="text" id="exsets" name="exsets" required/>
        <br /><label for="exreps">Reps:</label>
        <input type="text" id="exreps" name="exreps" required/>
        <br /><label for="exweight">Weight:</label>
        <input type="text" id="exweight" name="exweight" required/>
        <br /><input type="submit" value="Add excercise!" />
    </form>
</div>

<div id="meal">
    <h1>Meals</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Amount</th>
            <th>Type</th>
            <th>Date</th>
        </tr>
        <c:forEach items="${meals}" var="meal">
            <tr>
                <td>${meal.name}</td>
                <td>${meal.amount}</td>
                <td>${meal.type}</td>
                <td>${meal.mealDate}</td>
                <td><form action="/delete-${meal.id}-meal" method="get"><input type="submit" value="DELETE" /></form></td>
            </tr>
        </c:forEach>
    </table>
    <form method="get" action="/addMeal">
        <br /><label for="mmeal">Meal:</label>
        <input type="text" id="mmeal" name="mmeal" required/>
        <br /><label for="mamount">Amount:</label>
        <input type="text" id="mamount" name="mamount" required/>
        <br /><label for="mtype">Type:</label>
        <input type="text" id="mtype" name="mtype" required/>
        <br /><input type="submit" value="Add meal!" />
    </form>
</div>

<div id="suplements">
    <h1>Suplements</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Amount</th>
            <th>Date</th>
        </tr>
        <c:forEach items="${suplements}" var="s">
            <tr>
                <td>${s.name}</td>
                <td>${s.amount}</td>
                <td>${s.datePurchased}</td>
                <td><form action="/delete-${s.id}-suplement" method="get"><input type="submit" value="DELETE" /></form></td>
            </tr>
        </c:forEach>
    </table>
    <form method="get" action="/addSuplement">
        <br /><label for="sname">Suplement:</label>
        <input type="text" id="sname" name="sname" required/>
        <br /><label for="samount">Amount:</label>
        <input type="text" id="samount" name="samount" required/>
        <br /><input type="submit" value="Add suplement!" />
    </form>
</div>

<div id="clipboard">
    <h1>Your clipboard</h1>
    <table>
        <tr>
            <th>Content</th>
        </tr>
        <c:forEach items="${userClipboards}" var="u">
            <tr>
                <td>${u.content}</td>
                <td><form action="/delete-${u.id}-clipboard" method="get"><input type="submit" value="DELETE" /></form></td>
            </tr>
        </c:forEach>
    </table>
    <form method="get" action="/addUserClipboard">
        <br /><label for="ccontent">Content:</label>
        <input type="text" id="ccontent" name="ccontent" required/>
        <br /><input type="submit" value="Add something to your clipboard!" />
    </form>
</div>

<div id="quotes">
    <h1>Your Quotes</h1>
    <table>
        <tr>
            <th>Content</th>
        </tr>
        <c:forEach items="${userQuotes}" var="q">
            <tr>
                <td>${q.content}</td>
                <td><form action="/delete-${q.id}-quote" method="get"><input type="submit" value="DELETE" /></form></td>
            </tr>
        </c:forEach>
    </table>
    <form method="get" action="/addQuote">
        <br /><label for="qcontent">Content:</label>
        <input type="text" id="qcontent" name="qcontent" required/>
        <br /><input type="submit" value="Add quote!" />
    </form>
</div>
</div>

<%@ include file="footer.jsp" %>
