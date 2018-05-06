<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 5/6/18
  Time: 12:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show result search</title>
</head>
<body>
<p>Show result search</p>
<tr>
    <td>Name</td>
    <td>Price</td>
    <td>Discription</td>
    <td>Producer</td>
</tr>
<tr>
    <td>${requestScope["product"].getName()}</td>
    <td>${requestScope["product"].getPrice()}</td>
    <td>${requestScope["product"].getDesription()}</td>
    <td>${requestScope["product"].getProducer()}</td>
</tr>
</body>
</html>
