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
           item.setId(Integer.parseInt(request.getParameter("id")));
           
           if(((ItemAddServiceImpl)session.getAttribute("item_service")).deleteItem(item, true)){
        	   response.sendRedirect("item.jsp");
           }
           else{
        	   response.sendRedirect("item.jsp");
           }
       %>
   </body>
</html>