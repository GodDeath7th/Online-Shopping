<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 8/24/19
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
    <p><c:if test="${not empty sessionScope.u}">
        ${u.name}hello
    </c:if></p>

    <a href="logout">Logout</a>
    <a href="UserManage.jsp">user management</a>
</body>
</html>
