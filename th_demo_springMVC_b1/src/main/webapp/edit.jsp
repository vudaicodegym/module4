<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/10/2022
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<center>
    <form action="/edited?id=${product.id}" method="post">
        <table border="2" align="5">
            <tr>
                <th>old product:</th>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td><img src="${product.img}" width="30%" height="30%"></td>
                <%--            <td>--%>
                <%--                <button><a href="/delete?id=${p.id}">delete</a></button>--%>
                <%--                <button><a href="/edit?id=${p.id}">edit</a></button>--%>
                <%--            </td>--%>
            </tr>
            <tr>
                <th>new product</th>
                <td>id can not be edited</td>
                <td><input type="text" name="name" placeholder="new name"></td>
                <td><input type="text" name="img" placeholder="img link"></td>
            </tr>
            <tr>
                <td colspan="4"><input type="submit" value="submit"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
