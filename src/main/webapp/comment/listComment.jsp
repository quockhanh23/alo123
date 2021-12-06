<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 12/6/2021
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/comments?action=createComment">Create new</a>
<c:forEach var="cus" items="${alo}">
   <h4>${cus.id} ${cus.accountId} ${cus.productId} ${cus.content}${cus.orderId}
    </h4>
</c:forEach>
    </body>
</html>
