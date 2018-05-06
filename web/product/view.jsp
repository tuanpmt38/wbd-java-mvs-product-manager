<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 5/4/18
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail product</title>
</head>
<body>
<table border="1px">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Discription</td>
        <td>Producer</td>
    </tr>
    <tr>
        <td>${requestScope["products"].getName()}</td>
        <td>${requestScope["products"].getPrice()}</td>
        <td>${requestScope["products"].getDesription()}</td>
        <td>${requestScope["products"].getProducer()}</td>
    </tr>
</table>
</body>
</html>
