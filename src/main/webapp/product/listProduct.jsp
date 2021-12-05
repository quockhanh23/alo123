<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 12/4/2021
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>List Product</h2>
<a href="/products?action=createProduct">Create new product</a>
<a href="/products?action=showListByOrderName">Sort by name</a>
</h2>
<form action="/products">
    <input type="text" name="key">
    <button>Find Name Product</button>
</form>
<c:forEach var="cus" items="${alo}">
<h4>${cus.id} ${cus.name} ${cus.price} ${cus.description} ${cus.action}
        ${cus.capacity} ${cus.barrel} ${cus.weight} ${cus.img} ${cus.categoryId} ${cus.quantity}

    <a href="/products?action=editProduct&id=${cus.id}">Edit</a>
    <a href="/products?action=deleteProduct&id=${cus.id}">Delete</a>
    </h4>
    </c:forEach>
</body>
</html>
