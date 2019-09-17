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
       <% 
           Item item = new Item();
           item.setUserId(Integer.parseInt(request.getParameter("userId")));
           item.setName(request.getParameter("name"));
           item.setCategory(request.getParameter("category"));
           item.setPrice(Float.parseFloat(request.getParameter("price")));
           item.setStock(Integer.parseInt(request.getParameter("stock")));
           item.setDescription(request.getParameter("description"));
           
           if(((ItemAddServiceImpl)session.getAttribute("item_service")).addItem(item, true)){
        	   response.sendRedirect("item.jsp");
           }
           else{
        	   response.sendRedirect("item-add.jsp");
           }
       %>
   </body>
</html>