<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="controller.UserLogin" %>
<%@ page import="entity.User" %>

<!DOCTYPE html>
<html>
   <head>
       <title>K-SHOP</title>
       <link rel="stylesheet" href="vendor/bootstrap-4.1/bootstrap.min.css">
   </head>
   
   <body>
   	    	   
   	   <a href = "register.jsp">click here to register</a>
       <h1>----------------------------------------------------</h1>
       <%
           if(session.getAttribute("user") == null){
        	   out.println("<a href = 'Login.jsp'>click here to login</a>");
           }
           else{
        	   User user = (User)session.getAttribute("user");
        	   out.print("welcome ");
        	   out.print(user.getName());
        	   out.print("</br>");
        	   out.println("<a href = 'profle.jsp'>profile</a>");
        	   out.println("<a href = 'item.jsp'>item</a>");
        	   
           }
       %>
   </body>
</html>