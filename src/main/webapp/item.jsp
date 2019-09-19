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
           int id = ((User)session.getAttribute("user")).getId();
           if(session.getAttribute("item_service") == null){
               ItemAddServiceImpl itemService = new ItemAddServiceImpl();
               session.setAttribute("item_service", itemService);
           }
		   ArrayList<Item> itemList = ((ItemAddServiceImpl)session.getAttribute("item_service")).getItem(id);
           session.setAttribute("itemList", itemList);
           response.sendRedirect("index.jsp");
		   
           /*if(items.size() == 0){
        	   out.println("<h1>you don't have any item now</h1>");
           }
           else{
        	   for(Item item:items){
        		   out.println("name: "+item.getName()+"</br>");
        		   out.println("category: "+item.getCategory()+"</br>");
        		   out.println("price: "+item.getPrice()+"</br>");
        		   out.println("stock: "+item.getStock()+"</br>");
        		   out.println("description: "+item.getDescription()+"</br>");
        		   out.println("<form action='item-update.jsp' method='post'> "+
        	   	               "<input type='hidden' name='id' value = '"+item.getId()+"'/>"+
        	   	               "<input type='hidden' name='name' value = '"+item.getName()+"'/>"+
        	   	               "<input type='hidden' name='price' value = '"+item.getPrice()+"'/>"+
        	   	               "<input type='hidden' name='stock' value = '"+item.getStock()+"'/>"+
        	   	               "<input type='hidden' name='description' value = '"+item.getDescription()+"'/>"+
        	   	               "<button type='submit'>update</button></form>");
        		   out.println("<form action='item-delete-process.jsp' method='post'> "+
    	   	                   "<input type='hidden' name='id' value = '"+item.getId()+"'/>"+
    	   	                   "<button type='submit'>delete</button></form>");
        		   
        	   }
           }
           out.println("<a href = 'item-add.jsp'>add</a>"); */
       %>
       
   </body>
</html>