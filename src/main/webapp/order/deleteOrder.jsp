<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 12/5/2021
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        button {
            background: #0f3b62;
            color: whitesmoke;
            border: none;
            font-size: 25px;
            border-radius: 5px;
            margin-top: 10px;
            transition: 0.3s;
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        }
        button:hover {
            transform: scale(1.2);
        }

        body {
            background: #1b6d85;
            color: whitesmoke;
        }
    </style>
</head>
<body>
<h2 style="text-align: center">Delete form information</h2>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Id Order</th>
                <td>${aloDelete.id}</td>
            </tr>
            <tr>
                <th>Account Id</th>
                <td>${aloDelete.accountId}</td>
            </tr>
            <tr>
                <th>Date</th>
                <td>${aloDelete.time}</td>
            </tr>
            <tr>
                <th>Status</th>
                <td>${aloDelete.status}</td>
            </tr>
        </table>
        <button>Delete</button>
        <button><a style="text-decoration: none; color: whitesmoke" href="/orders">Back to list order</a></button>
    </form>
</div>
</body>
</html>
