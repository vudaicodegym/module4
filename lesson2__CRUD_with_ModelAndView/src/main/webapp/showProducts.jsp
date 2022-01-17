<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 10/01/2022
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Đây là trang show Product</h1>
<button><a href="/create">Create</a></button>
<table border="1">
    <c:forEach items="${products}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
<%--            <td><img src="${p.img}" width="30%" height="30%"></td>--%>
            <td>${p.img}</td>
            <td>
                <button><a href="/delete?id=${p.id}">delete</a></button>
                <button><a href="/edit?id=${p.id}">edit</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
