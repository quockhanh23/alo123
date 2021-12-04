<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 12/4/2021
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/carts?action=createCart">create new cart</a>
<c:forEach var="cus" items="${alo}">
<h2>${cus.id} ${cus.accountId}
    <a href="/carts?action=editCart&id=${cus.id}">Edit</a>
    <a href="/carts?action=deleteCart&id=${cus.id}">Delete</a>
</h2>
</c:forEach>
</body>
</html>
