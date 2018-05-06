<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 5/5/18
  Time: 11:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>
<p>
    <a href="/products">back to list pages</a>
</p>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>

<table border="1px">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Discription</td>
        <td>Produrce</td>
    </tr>
    <tr>
        <form method="post">
        <td>
            <label>Name</label>
            <input type="text" name = "name" id = "name" value="${requestScope["products"].getName()}">
        </td>
        <td>
            <label>Price</label>
            <input type="text" name = "price" id = "price" value="${requestScope["products"].getPrice()}">
        </td>
        <td>
            <label>Discriptsion</label>
            <input type="text" name = "discription" id = "discription" value="${requestScope["products"].getDesription()}">
        </td>
        <td>
            <input type="text" name = "produrce" id = "produrce" value="${requestScope["products"].getProducer()}">
            <button type="submit">update</button>
        </td>
        </form>
    </tr>

</table>
</body>
</html>
