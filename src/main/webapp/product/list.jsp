<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${products}" var="pt">
    <h1>${pt.id},${pt.name},${pt.price},${pt.description},${pt.action},${pt.capacity},${pt.barrel},${pt.weight},${pt.img},${pt.categoryId},${pt.quantity}</h1>
</c:forEach>
</body>
</html>
