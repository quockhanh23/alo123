<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/4/2021
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Edit</h1>
    <form method="post">
         <input type="text" name="id" value="${product.getId()}">
         <input type="text" name="name" value="${product.getName()}">
         <input type="text" name="price" value="${product.getPrice()}">
         <input type="text" name="description" value="${product.getDescription()}">
         <input type="text" name="action" value="${product.getAction()}">
         <input type="text" name="capacity" value="${product.getCapacity()}">
         <input type="text" name="barrel" value="${product.getBarrel()}">
         <input type="text" name="weight" value="${product.getWeight()}">
         <input type="text" name="img" value="${product.getImg()}">
         <input type="text" name="categoryId" value="${product.getCategoryId()}">
         <input type="text" name="quantity" value="${product.getQuantity()}">
        <button>Edit</button>
    </form>
</center>
</body>
</html>
