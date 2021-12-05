<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 12/5/2021
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit form</h2>
<form method="post">
    <input type="number" name="accountId" value="${aloEdit.accountId}">
    <input type="text" name="time" value="${aloEdit.time}">
    <input type="number" name="status" value="${aloEdit.status}">
    <button>Edit</button>
</form>
</body>
</html>
