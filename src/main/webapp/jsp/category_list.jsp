<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 9/15/19
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table id ="category" >
    <tbody>
    <c:forEach items="${categoryList}" var="category" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${category.name}</td>
            <td>${category.number}</td>
        </tr>

    </c:forEach>
    </tbody>

</table>

</body>
</html>
