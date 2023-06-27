<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kowal
  Date: 27.06.2023
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Użytkownik o id ${user.id}</title>
</head>
<body>
<form method="get" action="/user/add">
  <button type="submit">Dodaj użytkownika</button>
</form>
<br><br>
<table>
  <thead>
  <tr>
    <td>Szczegóły użytkownika</td>

  </tr>
  </thead>

    <tr>
      <td>id</td>
      <td>${user.id}</td>
    </tr>
  <tr>
    <td>Nazwa Użytkownika</td>
    <td>${user.userName}</td>
  </tr>
  <tr>
    <td>Email</td>
    <td>${user.email}</td>
  </tr>

</table>

<form method="post">
  <button type="submit">Ok</button>
</form>

</body>
</html>
