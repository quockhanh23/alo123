<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 12/5/2021
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>List Order</h2>
<a href="/orders?action=createOrder">Create new order</a>
<c:forEach var="cus" items="${alo}">
    <h4>${cus.id} ${cus.accountId} ${cus.time}${cus.status}
        <a href="/orders?action=deleteOrder&id=${cus.id}">Delete</a>
    </h4>
</c:forEach>
</body>
</html>
