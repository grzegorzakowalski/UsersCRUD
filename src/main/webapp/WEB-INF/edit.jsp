<%--
  Created by IntelliJ IDEA.
  User: kowal
  Date: 27.06.2023
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj użytkownika o id ${id}</title>
</head>
<body>
<form method="get" action="/user/list">
    <button type="submit">Lista użytkowników</button>
</form>
<br><br>
<c:if test="${not empty msg}">
    ${msg}<br>
</c:if>
<form method="POST">
    <label for="username">Nazwa</label>
    <input type="text" id="username" name="username" placeholder="${user.userName}" required><br><br>

    <label for="email">Email</label>
    <input type="email" id="email" name="email" placeholder="${user.email}" required><br><br>

    <label for="password">Hasło</label>
    <input type="password" id="password" name="password" placeholder="Podaj nowe hasło" required><br><br>
    <input type="hidden" name="id" value="${id}">

    <button type="submit">Zapisz</button>
</form>

</body>
</html>
