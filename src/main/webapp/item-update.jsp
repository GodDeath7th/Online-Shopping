<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="serviceImp.ItemAddServiceImpl" %>
<%@ page import="entity.User" %>
<%@ page import="entity.Item" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
   <head>
       <title>K-SHOP</title>
       <link rel="stylesheet" href="vendor/bootstrap-4.1/bootstrap.min.css">
   </head>
   
   <body>
       <form action = "item-update-process.jsp" method = "post">
        <input type = "hidden" name = "id" value = "<%= request.getParameter("id") %>" />
        name:<input type="text" name="name" value = "<%= request.getParameter("name") %>"></br>
        price:<input type="text" name="price" value = "<%= request.getParameter("price") %>"></br>
        stock:<input type="text" name="stock" value = "<%= request.getParameter("stock") %>"></br>
        description:<input type="text" name="description" value = "<%= request.getParameter("description") %>"></br>
        <select name = "category">
         <option value="clothes">clothes</option>
         <option value="food">food</option>
         <option value="e-product">e-product</option>
         <option value="others">others</option>
        </select>
        <button type = "submit">update</button>
       </form>
       <a href = "item.jsp">back</a>
   </body>
</html>