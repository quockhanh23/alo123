<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 12/4/2021
  Time: 3:55 PM
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
        <div id="1">
            <table border="1" cellpadding="5">
                <tr>
                    <th><h3>Id Cart</h3></th>
                    <td><h3>${aloDelete.id}</h3></td>
                </tr>
                <tr>
                    <th><h3> Account</h3></th>
                    <td><h3>${aloDelete.accountId}</h3></td>
                </tr>
            </table>
        </div>
      <div id="2"><button>Delete</button></div>
        <div><button><a style="text-decoration: none; color: whitesmoke" href="/carts">Back to list cart</a></button></div>
    </form>
</div>
</body>
</html>
