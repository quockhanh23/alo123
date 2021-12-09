<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: susu
  Date: 07/12/2021
  Time: 9:20 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Electro - HTML Ecommerce Template</title>
    <link href="img/logo1.png" rel="icon">
    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

    <!-- nouislider -->
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="css/style.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <style>
        td{
            padding:60px 60px;
        }
    </style>
</head>
<body>
<!-- HEADER -->
<header>
    <!-- TOP HEADER -->
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> email@email.com</a></li>
                <li><a href="#"><i class="fa fa-map-marker"></i> 1734 Stonecoal Road</a></li>
            </ul>
            <ul class="header-links pull-right">
                <c:if test="${sessionScope.acc != null}">
                    <li><a href="#"><i class="fa fa-dollar"></i> Wallet: ${sessionScope.acc.balance}</a></li>
                    <li><a href="#"><i class="fas fa-user"></i> Hello ${sessionScope.acc.name}</a></li>
                    <c:if test="${sessionScope.acc.roleId == 1}">
                        <li><a href="/manager1"><i class="fas fa-user"></i> Manager</a></li>
                    </c:if>
                    <li><a href="/accounts?action=logout"><i class="fa"></i> Logout</a></li>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <li><a href="#"><i class="fas fa-user"></i> Guest</a></li>
                    <li><a href="/accounts?action=login"><i class="fa"></i> Login</a></li>
                </c:if>
            </ul>
        </div>
    </div>
    <!-- /TOP HEADER -->

    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="#" class="logo">
                            <img width="80px" height="80px" src="./img/logo1.png" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-4">
                    <div class="header-search">
                        <form>
                            <input style="width: 240px !important;" class="input" placeholder="Search here">
                            <button class="search-btn">Search</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-5 clearfix">
                    <div class="header-ctn">
                        <!-- Wishlist -->
                        <div>
                            <a style="width: 120px" href="#">
                                <i class="far fa-heart"></i>
                                <span>Deposit money</span>
                                <div></div>
                            </a>
                        </div>
                        <!-- /Wishlist -->
                        <!-- Wishlist -->
                        <div>
                            <a style="width: 120px" href="/orders?action=showUserOrder">
                                <i class="far fa-heart"></i>
                                <span>Your Order List</span>
                                <div ></div>
                            </a>
                        </div>
                        <!-- /Wishlist -->

                        <!-- Cart -->
                        <div class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                <i class="fa fa-shopping-cart"></i>
                                <span>Your Cart</span>
                                <div class="qty">${sum}</div>
                            </a>
                            <div class="cart-dropdown">
                                <div class="cart-list">

                                    <c:forEach var="i" begin="0" end="${sessionScope.productsInCart.size()-1}">
                                        <c:if test="${sessionScope.cartDetails.get(i).quantity >0}">
                                            <div class="product-widget">
                                                <div class="product-img">
                                                    <img src="./img/${sessionScope.productsInCart.get(i).img}" alt="">
                                                </div>
                                                <div class="product-body">
                                                    <h3 class="product-name"><a href="#">${sessionScope.productsInCart.get(i).name}</a></h3>
                                                    <h4 class="product-price"><span class="qty">${sessionScope.cartDetails.get(i).quantity}x</span>$${sessionScope.productsInCart.get(i).price}</h4>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>

                                </div>
                                <div class="cart-summary">
                                    <small>${sum} Item(s) selected</small>
                                    <h5>SUBTOTAL: $${sessionScope.totalInCart}</h5>
                                </div>
                                <div class="cart-btns">
                                    <a href="/carts?action=showCusCart">View Cart</a>
                                    <a href="/orders">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                        <!-- /Cart -->

                        <!-- Menu Toogle -->
                        <div class="menu-toggle">
                            <a href="#">
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!-- /Menu Toogle -->
                    </div>
                </div>
                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->

<!-- NAVIGATION -->
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
            <!-- NAV -->
            <ul class="main-nav nav navbar-nav">
                <li class="active"><a href="/homes">Home</a></li>
                <li><a href="/products">All product</a></li>
                <li><a href="/products?action=showCate&cateId=1">Hand gun</a></li>
                <li><a href="/products?action=showCate&cateId=2">Rifle</a></li>
                <li><a href="/products?action=showCate&cateId=3">Shot gun</a></li>
                <li><a href="/products?action=showCate&cateId=4">Snipe</a></li>
            </ul>
            <!-- /NAV -->
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->

<!-- BREADCRUMB -->
<div id="breadcrumb" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <h3 class="breadcrumb-header">Your cart</h3>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /BREADCRUMB -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th style="text-align: center" scope="col">Num.</th>
                    <th style="text-align: center" scope="col">Product</th>
                    <th style="text-align: center" scope="col">Image</th>
                    <th style="text-align: center" scope="col">Price</th>
                    <th style="text-align: center" scope="col">Quantity</th>
                    <th style="text-align: center" scope="col">Total</th>
                    <th style="text-align: center" scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" begin="0" end="${sessionScope.cartDetails.size() -1}">
                    <c:if test="${sessionScope.cartDetails.get(i).quantity > 0}">
                <tr>
                    <th style="padding: 60px 60px;text-align: center" scope="row">${i+1}</th>
                    <td style="padding: 60px 60px;text-align: center"><a href="products?action=viewProduct&id=${sessionScope.productsInCart.get(i).id}">${sessionScope.productsInCart.get(i).name}</a></td>
                    <td><img src="./img/${sessionScope.productsInCart.get(i).img}" width="131" height="131"></td>
                    <td style="padding: 60px 60px;text-align: center">${sessionScope.productsInCart.get(i).price}$</td>
                    <td style="padding: 60px 5px;text-align: center">
                        <a href="/carts?action=minus&productId=${sessionScope.productsInCart.get(i).id}"><i class="fas fa-minus"></i></a>
                        &ensp;${sessionScope.cartDetails.get(i).quantity}&ensp;
                        <a href="/carts?action=plus&productId=${sessionScope.productsInCart.get(i).id}"><i class="fas fa-plus"></i></a>
                    </td>
                    <td style="padding: 60px 60px;text-align: center">${sessionScope.productsInCart.get(i).price*sessionScope.cartDetails.get(i).quantity}$</td>
                    <td style="padding: 60px 60px;text-align: center"><a onclick="return confirm('Are you sure to delete product?')" href="/carts?action=deleteProduct&productId=${sessionScope.productsInCart.get(i).id}" class="delete"><i class="fas fa-trash-alt"></i></a></td>
                </tr>
                    </c:if>
                </c:forEach>

                <tr>
                    <th style="padding: 60px 60px" scope="row">Total</th>
                    <td colspan="4"> </td>
<%--                    <td>@twitter</td>--%>
<%--                    <td>@twitter</td>--%>
                    <td style="padding: 60px 60px">${sessionScope.totalInCart}$</td>
                    <td style="padding: 60px 60px;text-align: center"><a onclick="return confirm('Are you sure to delete all product?')" href="/carts?action=deleteAllProduct" class="delete"><i class="fas fa-trash-alt"></i></a></td>
                </tr>
                </tbody>
            </table>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- NEWSLETTER -->
<div id="newsletter" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="newsletter">
                    <p>Sign Up for the <strong>NEWSLETTER</strong></p>
                    <form>
                        <input class="input" type="email" placeholder="Enter Your Email">
                        <button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
                    </form>
                    <ul class="newsletter-follow">
                        <li>
                            <a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /NEWSLETTER -->

<!-- FOOTER -->
<footer id="footer">
    <!-- top footer -->
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">About Us</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>
                        <ul class="footer-links">
                            <li><a href="#"><i class="fa fa-map-marker"></i>1734 Stonecoal Road</a></li>
                            <li><a href="#"><i class="fa fa-phone"></i>+021-95-51-84</a></li>
                            <li><a href="#"><i class="fa fa-envelope-o"></i>email@email.com</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Categories</h3>
                        <ul class="footer-links">
                            <li><a href="#">Hot deals</a></li>
                            <li><a href="#">Laptops</a></li>
                            <li><a href="#">Smartphones</a></li>
                            <li><a href="#">Cameras</a></li>
                            <li><a href="#">Accessories</a></li>
                        </ul>
                    </div>
                </div>

                <div class="clearfix visible-xs"></div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Information</h3>
                        <ul class="footer-links">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Orders and Returns</a></li>
                            <li><a href="#">Terms & Conditions</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Service</h3>
                        <ul class="footer-links">
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">View Cart</a></li>
                            <li><a href="#">Wishlist</a></li>
                            <li><a href="#">Track My Order</a></li>
                            <li><a href="#">Help</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /top footer -->

    <!-- bottom footer -->
    <div id="bottom-footer" class="section">
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-12 text-center">
                    <ul class="footer-payments">
                        <li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
                        <li><a href="#"><i class="fa fa-credit-card"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
                    </ul>
                    <span class="copyright">
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</span>


                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /bottom footer -->
</footer>
<!-- /FOOTER -->

<!-- jQuery Plugins -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>

