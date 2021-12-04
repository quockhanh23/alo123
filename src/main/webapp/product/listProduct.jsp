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
<h2>List product</h2>
<a href="/products?action=createProduct">create new product</a>
</h2>

<c:forEach var="cus" items="${alo}">
<h2>${cus.id} ${cus.name} ${cus.price} ${cus.description} ${cus.action}
        ${cus.capacity} ${cus.barrel} ${cus.weight} ${cus.img} ${cus.categoryId} ${cus.quantity}

    <a href="/product?action=editProduct&id=${cus.id}">Edit</a>
    <a href="/product?action=deleteProduct&id=${cus.id}">Delete</a>
    </h2>
    </c:forEach>
</body>
</html>
