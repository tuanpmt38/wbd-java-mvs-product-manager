<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 5/5/18
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update product</title>
</head>
<body>
<h1>Edit product</h1>
<p>
    <a href="/products">back to list page</a>
</p>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<form method="post">
    <fieldset>
    <label>Name</label>
    <input type="text" name = "name" id = "name" value="${requestScope["products"].getName()}">

    <label>Price</label>
    <input type="text" name = "price" id = "price" value="${requestScope["products"].getPrice()}">

    <label>Discriptsion</label>
    <input type="text" name = "discription" id = "discription" value="${requestScope["products"].getDesription()}">

    <label>Produrce</label>
    <input type="text" name = "produrce" id = "produrce" value="${requestScope["products"].getProducer()}">
    <button type="submit">update</button>
    </fieldset>
</form>

</body>
</html>
