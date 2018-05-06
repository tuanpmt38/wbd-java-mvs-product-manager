<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 5/3/18
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List product</title>
</head>
<body>
<table border="1px">
    <h1>List product</h1>
    <p>
        <a href="/products?action=create">Creat new Product</a>
    </p>
    <form  method="get"><input type="text" name="key" action="product/search"><button >Search</button></form><br>
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Discription</td>
        <td>Producer</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items = '${requestScope["products"]}' var="product">
    <tr>
        <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
        <td>${product.getPrice()}</td>
        <td>${product.getDesription()}</td>
        <td>${product.getProducer()}</td>
        <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
        <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
    </tr>
    </c:forEach>

</table>
</body>
</html>
