<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kowal
  Date: 27.06.2023
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Czy chcesz usunąć użytkownika o id ${id}</title>
</head>
<body>
Czy na pewno chcesz usunąć użytkownika ${name}?<br>
<form method="post">
    <input type="hidden" name="id" value="${id}">
  <button type="submit">Tak</button>
</form>
<form method="get" action="<c:url value="/user/list" />">
  <button type="submit">Nie</button>
</form>

</body>
</html>
