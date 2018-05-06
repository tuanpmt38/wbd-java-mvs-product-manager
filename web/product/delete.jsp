<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 5/6/18
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<a href="">back to list page</a>
<h1>Are you delete ?</h1>
<table border="1px">
    <form action="" method="post">
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
        <td><input type="submit" value="Delete customer"></td>
    </tr>

    </form>

</table>
</body>
</html>
