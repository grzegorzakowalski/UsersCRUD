<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kowal
  Date: 27.06.2023
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista użytkowników</title>
</head>
<body>
<form method="get" action="/user/add">
    <button type="submit">Dodaj użytkownika</button>
</form>
<br>
<br>
<c:if test="${not empty msg}">
    ${msg}<br>
</c:if>
<br>
<table>
    <thead>
    <tr>
        <td>id</td>
        <td>Nazwa użytkownika</td>
        <td>Email</td>
        <td>Akcja</td>
    </tr>
    </thead>

<c:forEach items="${users}" var="user">
<c:if test="${user.visible == '1'}">
    <tr>
        <td>${user.id}</td>
        <td>${user.userName}</td>
        <td>${user.email}</td>
        <td>
            <form method="post" action="/user/delete" >
                <button type="submit" value="${user.id}" name="id">Usuń</button>
            </form>
            <form method="get" action="/user/edit">
                <button type="submit" value="${user.id}" name="id">Edytuj</button>
            </form>
            <form method="get" action="/user/show">
                <button type="submit" value="${user.id}" name="id">Pokaż</button>
            </form>
        </td>
    </tr>
</c:if>
</c:forEach>
</table>

</body>
</html>
