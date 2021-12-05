<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 12/5/2021
  Time: 5:22 PM
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
            font-size: 20px;
            border-radius: 5px;
        }

        body {
            background: #1b6d85;
            color: whitesmoke;
        }
    </style>
</head>
<body>
<h2 style="text-align: center">From Create</h2>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Enter Id</th>
                <td><input type="number" name="id" placeholder="id"></td>
            </tr>
            <tr>
                <th>Enter Id Account</th>
                <td><input type="number" name="accountId" placeholder="account ID"></td>
            </tr>
            <tr>
                <th>Enter Date</th>
                <td><input type="text" name="time" placeholder="time"></td>
            </tr>
            <tr>
                <th>Enter Status</th>
                <td><input type="number" name="status" placeholder="status"></td>
            </tr>
        </table>
        <button>Create</button>
    </form>
</div>
</body>
</html>
