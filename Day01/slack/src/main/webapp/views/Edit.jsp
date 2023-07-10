<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09-Jul-23
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Img</th>
            </tr>
            <tr>
                <td><input value="${student.id}" hidden="hidden" name="id">${student.id}</td>
                <td><input value="${student.name}" name="name"><br></td>
                <td><input value="${student.age}" name="age"><br></td>
                <td><input value="${student.img}" name="img"><br></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
