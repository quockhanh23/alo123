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
<c:forEach var="cus" items="${alo}">
<h2>${cus.id} ${cus.accountId}</h2>
</c:forEach>
</body>
</html>
