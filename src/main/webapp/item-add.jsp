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
       <% int userId = ((User)session.getAttribute("user")).getId(); %>
       <form action = "item-add-process.jsp" method = "post">
        <input type = "hidden" name = "userId" value = "<%= userId %>" />
        name:<input type="text" name="name" /></br>
        price:<input type="text" name="price" /></br>
        stock:<input type="text" name="stock" /></br>
        description:<input type="text" name="description" /></br>
        <select name = "category">
         <option value="clothes">clothes</option>
         <option value="food">food</option>
         <option value="e-product">e-product</option>
         <option value="others">others</option>
        </select>
        <button type = "submit">add</button>
       </form>
       <a href = "item.jsp">back</a>
   </body>
</html>