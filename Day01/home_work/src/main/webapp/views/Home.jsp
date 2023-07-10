<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10-Jul-23
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Blog</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h2>List Blog</h2>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Category</th>
            <th>Comment</th>
            <th>Edit</th>
        </tr>
        </thead>
        <c:forEach var="b" items="${list}">
            <tr>
                <td>${b.getId()}</td>
                <td>${b.getName()}</td>
                <td>${b.getCategory()}</td>
                <td>${b.getTopic()}</td>
                <th>${b.getIdListComment()}</th>
                <th><a href="/edit?id=${b.getId()}" type="button" class="btn btn-info" >Edit</a></th>
                <th><a href="/delete?id=${b.getId()}" type="button" class="btn btn-info" >Del</a></th>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

