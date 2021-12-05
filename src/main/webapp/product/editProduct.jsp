<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 12/4/2021
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h2>From edit</h2>
<form method="post">
<%--    <input type="number" name="id" value="${aloEdit.id}" placeholder="id product">--%>
    <input type="text" name="name" value="${aloEdit.name}" placeholder="name product">
    <input type="number" name="price" value="${aloEdit.price}" placeholder="price">
    <input type="text" name="description" value="${aloEdit.description}" placeholder="description">
    <input type="text" name="action1" value="${aloEdit.action}" placeholder="action">
    <input type="text" name="capacity" value="${aloEdit.capacity}" placeholder="capacity">
    <input type="text" name="barrel" value="${aloEdit.barrel}" placeholder="barrel">
    <input type="text" name="weight" value="${aloEdit.weight}" placeholder="weight">
    <input type="text" name="img" value="${aloEdit.img}" placeholder="img">
    <input type="text" name="categoryId" value="${aloEdit.categoryId}" placeholder="category Id">
    <input type="number" name="quantity" value="${aloEdit.quantity}" placeholder="quantity">
    <button>Edit</button>
</form>
</body>
</html>
