<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style>
        .product img {
            width: 262px;
            height: 262px;
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
            <%--            <ul class="header-links pull-right">--%>
            <%--                <li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>--%>
            <%--                <li><a href="#"><i class="fa fa-user-o"></i> My Account</a></li>--%>
            <%--            </ul>--%>
            <ul class="header-links pull-right">
                <c:if test="${sessionScope.acc != null}">
                    <li><a href="#"><i class="fa fa-dollar"></i> Wallet: ${sessionScope.acc.balance}</a></li>
                    <li><a href="#"><i class="fa fa-user-o"></i> Hello ${sessionScope.acc.name}</a></li>
                    <c:if test="${sessionScope.acc.roleId == 1}">
                        <li><a href="/manager1"><i class="fa fa-user-o"></i> Manager</a></li>
                    </c:if>
                    <li><a href="/accounts?action=logout"><i class="fa"></i> Logout</a></li>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <li><a href="#"><i class="fa fa-user-o"></i> Guest</a></li>
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
                            <input style="width: 240px !important;" class="input" name="key" placeholder="Search here">
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
                                <i class="fa fa-heart-o"></i>
                                <span>Deposit money</span>
                                <div></div>
                            </a>
                        </div>
                        <!-- /Wishlist -->
                        <!-- Wishlist -->
                        <div>
                            <a style="width: 120px" href="/orders?action=showUserOrder">
                                <i class="fa fa-heart-o"></i>
                                <span>Your Order List</span>
                                <div></div>
                            </a>
                        </div>
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
                <ul class="breadcrumb-tree">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">All product</a></li>
                </ul>
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
            <!-- ASIDE -->
            <div id="aside" class="col-md-3">

                <!-- aside Widget -->
                <div class="aside">
                    <form action="/products?action=showCate&cateId=${cateId}" method="post">
                        <h3 class="aside-title">Price (Unit : *100$)</h3>
                        <div class="price-filter">
                            <div id="price-slider"></div>
                            <div class="input-number price-min">
                                <input id="price-min" value="1" name="min" type="number">
                                <span class="qty-up">+</span>
                                <span class="qty-down">-</span>
                            </div>
                            <span>-</span>
                            <div class="input-number price-max">
                                <input id="price-max" name="max" type="number">
                                <span class="qty-up">+</span>
                                <span class="qty-down">-</span>
                            </div>
                        </div>
                        <div>&ensp;</div>
                        <button type="submit" class="btn btn-danger">Search</button>
                    </form>
                </div>
                <!-- /aside Widget -->

                <!-- aside Widget -->

                <!-- /aside Widget -->

                <!-- aside Widget -->
                <div class="aside">
                    <h3 class="aside-title">New Product</h3>
                    <c:forEach var="cus" items="${alo1}">
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="./img/${cus.img}" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">${cus.categoryId}</p>
                                <h3 class="product-name"><a href="#">${cus.name}</a></h3>
                                <h4 class="product-price">${cus.price}$
                                </h4>
                            </div>
                        </div>
                    </c:forEach>

                </div>
                <!-- /aside Widget -->
            </div>
            <!-- /ASIDE -->

            <!-- STORE -->
            <div id="store" class="col-md-9">

                <!-- /store top filter -->

                <!-- store products -->
                <div class="row">
                    <!-- product -->
                    <c:forEach var="cus" items="${alo}">
                        <c:if test="${cateId ==1 && cus.categoryId == 'handgun'}">
                            <c:if test="${min == null}">
                    <a href="/products?action=viewProduct&id=${cus.id}">
                                <div class="col-md-4 col-xs-6">
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="./img/${cus.img}" alt="">
                                            <div class="product-label">
                                                <span class="new">Hot!</span>
                                            </div>
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${cus.categoryId}</p>
                                            <h3 class="product-name"><a href="#">${cus.name} </a></h3>
                                            <h4 class="product-price">${cus.price}$
                                            </h4>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>
                                                <a href="/carts?action=addPToCart&id=${cus.id}">add to cart</a>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                    </a>
                            </c:if>
                            <c:if test="${min != null}">
                                <c:if test="${cus.price >= min && cus.price <= max}">
                    <a href="/products?action=viewProduct&id=${cus.id}">
                                    <div class="col-md-4 col-xs-6">
                                        <div class="product">
                                            <div class="product-img">
                                                <img src="./img/${cus.img}" alt="">
                                                <div class="product-label">
                                                    <span class="new">Hot!</span>
                                                </div>
                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">${cus.categoryId}</p>
                                                <h3 class="product-name"><a href="#">${cus.name} </a></h3>
                                                <h4 class="product-price">${cus.price}$
                                                </h4>
                                            </div>
                                            <div class="add-to-cart">
                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>
                                                    <a href="/carts?action=addPToCart&id=${cus.id}">add to cart</a>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                    </a>
                                </c:if>
                            </c:if>
                        </c:if>
                        <c:if test="${cateId ==2 && cus.categoryId == 'rifle'}">
                            <c:if test="${min == null}">
                    <a href="/products?action=viewProduct&id=${cus.id}">
                                <div class="col-md-4 col-xs-6">
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="./img/${cus.img}" alt="">
                                            <div class="product-label">
                                                <span class="new">Hot!</span>
                                            </div>
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${cus.categoryId}</p>
                                            <h3 class="product-name"><a href="#">${cus.name} </a></h3>
                                            <h4 class="product-price">${cus.price}$
                                            </h4>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>
                                                <a href="/carts?action=addPToCart&id=${cus.id}">add to cart</a>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                    </a>
                            </c:if>
                            <c:if test="${min != null}">
                                <c:if test="${cus.price >= min && cus.price <= max}">
                    <a href="/products?action=viewProduct&id=${cus.id}">
                                    <div class="col-md-4 col-xs-6">
                                        <div class="product">
                                            <div class="product-img">
                                                <img src="./img/${cus.img}" alt="">
                                                <div class="product-label">
                                                    <span class="new">Hot!</span>
                                                </div>
                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">${cus.categoryId}</p>
                                                <h3 class="product-name"><a href="#">${cus.name} </a></h3>
                                                <h4 class="product-price">${cus.price}$
                                                </h4>
                                            </div>
                                            <div class="add-to-cart">
                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>
                                                    <a href="/carts?action=addPToCart&id=${cus.id}">add to cart</a>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                    </a>
                                </c:if>
                            </c:if>
                        </c:if>
                        <c:if test="${cateId ==3 && cus.categoryId == 'shotgun'}">
                            <c:if test="${min == null}">
                    <a href="/products?action=viewProduct&id=${cus.id}">
                                <div class="col-md-4 col-xs-6">
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="./img/${cus.img}" alt="">
                                            <div class="product-label">
                                                <span class="new">Hot!</span>
                                            </div>
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${cus.categoryId}</p>
                                            <h3 class="product-name"><a href="#">${cus.name} </a></h3>
                                            <h4 class="product-price">${cus.price}$
                                            </h4>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>
                                                <a href="/carts?action=addPToCart&id=${cus.id}">add to cart</a>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                    </a>
                            </c:if>
                            <c:if test="${min != null}">
                                <c:if test="${cus.price >= min && cus.price <= max}">
                    <a href="/products?action=viewProduct&id=${cus.id}">
                                    <div class="col-md-4 col-xs-6">
                                        <div class="product">
                                            <div class="product-img">
                                                <img src="./img/${cus.img}" alt="">
                                                <div class="product-label">
                                                    <span class="new">Hot!</span>
                                                </div>
                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">${cus.categoryId}</p>
                                                <h3 class="product-name"><a href="#">${cus.name} </a></h3>
                                                <h4 class="product-price">${cus.price}$
                                                </h4>
                                            </div>
                                            <div class="add-to-cart">
                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>
                                                    <a href="/carts?action=addPToCart&id=${cus.id}">add to cart</a>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                    </a>
                                </c:if>
                            </c:if>
                        </c:if>
                        <c:if test="${cateId ==4 && cus.categoryId == 'sniper rifle'}">
                            <c:if test="${min == null}">
                    <a href="/products?action=viewProduct&id=${cus.id}">
                                <div class="col-md-4 col-xs-6">
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="./img/${cus.img}" alt="">
                                            <div class="product-label">
                                                <span class="new">Hot!</span>
                                            </div>
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${cus.categoryId}</p>
                                            <h3 class="product-name"><a href="#">${cus.name} </a></h3>
                                            <h4 class="product-price">${cus.price}$
                                            </h4>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>
                                                <a href="/carts?action=addPToCart&id=${cus.id}">add to cart</a>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                    </a>
                            </c:if>
                            <c:if test="${min != null}">
                                <c:if test="${cus.price >= min && cus.price <= max}">
                    <a href="/products?action=viewProduct&id=${cus.id}">
                                    <div class="col-md-4 col-xs-6">
                                        <div class="product">
                                            <div class="product-img">
                                                <img src="./img/${cus.img}" alt="">
                                                <div class="product-label">
                                                    <span class="new">Hot!</span>
                                                </div>
                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">${cus.categoryId}</p>
                                                <h3 class="product-name"><a href="#">${cus.name} </a></h3>
                                                <h4 class="product-price">${cus.price}$
                                                </h4>
                                            </div>
                                            <div class="add-to-cart">
                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>
                                                    <a href="/carts?action=addPToCart&id=${cus.id}">add to cart</a>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                    </a>
                                </c:if>
                            </c:if>
                        </c:if>

                        <!-- /product -->
                    </c:forEach>
                    <div class="clearfix visible-sm visible-xs"></div>

                </div>
                <!-- /store products -->

            </div>
            <!-- /STORE -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->


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
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt
                            ut.</p>
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
                    <%--                    <span class="copyright">--%>
                    <%--								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->--%>
                    <%--								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i--%>
                    <%--                            class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com"--%>
                    <%--                                                                                target="_blank">Colorlib</a>--%>
                    <%--                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->--%>
                    <%--							</span>--%>
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
