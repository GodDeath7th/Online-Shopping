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

   	   <%
   	       String username = request.getParameter("username");
   	       String password = request.getParameter("password");
   	       User user = new UserLogin().login(username, password);
   	       if(user != null){
   	           session.setAttribute("user", user);
   	           response.sendRedirect("index.jsp");
   	       }
   	       else{
   	    	   String errorMessage = "true"; 
   	    	   session.setAttribute("login_error", errorMessage);
   	    	   response.sendRedirect("login.jsp");
   	       }
   	   %>
   </body>
</html>