<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10-Jul-23
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Category</th>
        <th>Comment</th>
        <th>Edit</th>
    </tr>
    <tr>
        <td><input value="${Blog.getid}" type="hidden">${Blog.getid}</td>
        <td><input value="${Blog.getname}"></td>
        <td><input value="${Blog.getcategory}"></td>
        <td><input value="${Blog.gettopic}"></td>
        <th><input value="${Blog.getidListComment}"></th>
    </tr>
</table>
</body>
</html>
