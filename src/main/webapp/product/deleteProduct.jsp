<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 12/4/2021
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <h1>Delete form information</h1>
    <h3>${aloDelete.id}</h3>
    <h3>${aloDelete.name}</h3>
    <h3>${aloDelete.price}</h3>
    <h3>${aloDelete.description}</h3>
    <h3>${aloDelete.action}</h3>
    <h3>${aloDelete.capacity}</h3>
    <h3>${aloDelete.barrel}</h3>
    <h3>${aloDelete.weight}</h3>
    <h3>${aloDelete.img}</h3>
    <h3>${aloDelete.categoryId}</h3>
    <h3>${aloDelete.quantity}</h3>
    <button>Delete</button>
</form>
</body>
</html>
