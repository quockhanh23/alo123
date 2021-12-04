<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/products?action=create"> create</a><br>
<c:forEach items="${products}" var="pt">
    <h5>
            ${pt.id},
            ${pt.name},
            ${pt.price},
            ${pt.description},
            ${pt.action},
            ${pt.capacity},
            ${pt.barrel},
            ${pt.weight},
            ${pt.img},
            ${pt.categoryId},
            ${pt.quantity}
</h5><a href="/products?action=delete&id=${pt.id}" onclick="if (confirm('Delete selected item?')){return true;}else{event.stopPropagation(); event.preventDefault();};" title="Link Title">delete</a>
    </h1>
</c:forEach>
</body>
</html>
