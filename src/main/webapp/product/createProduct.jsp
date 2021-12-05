<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 12/4/2021
  Time: 6:19 PM
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
<form method="post">
    <h2 style="text-align: center">From Create</h2>
    <div align="center">
        <form method="post">
            <table border="1" cellpadding="5">
                <tr>
                    <th>Enter Id</th>
                    <td><input type="number" name="id" placeholder="id"></td>
                </tr>
                <tr>
                    <th>Enter Name</th>
                    <td><input type="text" name="name" placeholder="name product"></td>
                </tr>
                <tr>
                    <th>Enter Price</th>
                    <td><input type="number" name="price" placeholder="price"></td>
                </tr>
                <tr>
                    <th>Enter Description</th>
                    <td><input type="text" name="description" placeholder="description"></td>
                </tr>
                <tr>
                    <th>Enter Action</th>
                    <td><input type="text" name="action1" placeholder="action"></td>
                </tr>
                <tr>
                    <th>Enter Capacity</th>
                    <td><input type="text" name="capacity" placeholder="capacity"></td>
                </tr>
                <tr>
                    <th>Enter Barrel</th>
                    <td><input type="text" name="barrel" placeholder="barrel"></td>
                </tr>
                <tr>
                    <th>Enter Weight</th>
                    <td><input type="text" name="weight" placeholder=""></td>
                </tr>
                <tr>
                    <th>Enter Image</th>
                    <td><input type="text" name="img" placeholder="img"></td>
                </tr>
                <tr>
                    <th>Enter Category Id</th>
                    <td><input type="text" name="categoryId" placeholder="category Id"></td>
                </tr>
                <tr>
                    <th>Enter Quantity</th>
                    <td><input type="number" name="quantity" placeholder="quantity"></td>
                </tr>
            </table>
            <button>Create</button>
        </form>
    </div>
</form>
</body>
</html>
