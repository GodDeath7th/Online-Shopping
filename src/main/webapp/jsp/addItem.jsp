<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 9/14/19
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="addItems" method="post">
    <input type="text" name="itemName">
    <select name = "item_category">
        <c:forEach items="${list}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <input type="text" name="item_id">
    <input type="text" name="price">
    <input type="text" name="stock">
    <input type="text" name="description">

    <button class="au-btn--submit" type="submit">submit</button>
</form>

</body>
</html>
