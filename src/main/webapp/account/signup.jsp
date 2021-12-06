<%--
  Created by IntelliJ IDEA.
  User: susu
  Date: 04/12/2021
  Time: 11:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
    <%--    https://use.fontawesome.com/releases/v5.8.1/css/all.css--%>
    <%--    https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js--%>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: sans-serif;
            background: linear-gradient(to right, #b92b27, #1565c0)
        }

        .card {
            margin-bottom: 20px;
            border: none
        }

        .box {
            width: 500px;
            padding: 40px;
            position: absolute;
            top: 50%;
            left: 50%;
            background: #191919;
            border-radius: 20px;
        ;
            text-align: center;
            transition: 0.25s;
            margin-top: 100px
        }

        .box input[type="text"],
        .box input[type="password"],
        .box input[type="tel"],
        .box input[type="email"]{
            border: 0;
            background: none;
            display: block;
            margin: 20px auto;
            text-align: center;
            border: 2px solid #3498db;
            padding: 10px 10px;
            width: 250px;
            outline: none;
            color: white;
            border-radius: 24px;
            transition: 0.25s
        }

        .box h1 {
            color: white;
            text-transform: uppercase;
            font-weight: 500
        }

        .box input[type="text"]:focus,
        .box input[type="password"]:focus,
        .box input[type="tel"]:focus,
        .box input[type="email"]:focus{
            width: 300px;
            border-color: #2ecc71
        }

        .box input[type="submit"] {
            border: 0;
            background: none;
            display: block;
            margin: 20px auto;
            text-align: center;
            border: 2px solid #2ecc71;
            padding: 14px 40px;
            outline: none;
            color: white;
            border-radius: 24px;
            transition: 0.25s;
            cursor: pointer
        }

        .box input[type="submit"]:hover {
            background: #2ecc71
        }

        .forgot {
            text-decoration: underline
        }
        #signup{
            border: 0;
            background: none;
            display: block;
            margin: 20px auto;
            text-align: center;
            border: 2px solid #2ecc71;
            padding: 14px 40px;
            outline: none;
            color: white;
            border-radius: 24px;
            transition: 0.25s;
            cursor: pointer;
            text-decoration: none;
        }
        #signup:hover{
            background: #2ecc71
        }

    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 ">
            <div class="card box">
                <form onsubmit="event.preventDefault()" >
                    <h1>Signup</h1>
                    <p class="text-muted"> Create your account!</p>
                    <input type="text" name="" placeholder="Username">
                    <input type="password" name="" placeholder="Password">
                    <input type="password" name="" placeholder="Re-Password">
                    <input type="tel" name="" placeholder="PhoneNumber">
                    <input type="email" name="" placeholder="email">
                    <input type="text" name="" placeholder="address">
                    <%--                    <a class="forgot text-muted" href="#">Forgot password?</a>--%>
                    <input type="submit" name="" value="Signup" href="#">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
