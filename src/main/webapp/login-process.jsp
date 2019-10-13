<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="controller.ControllerManager" %>
<%@ page import="dto.UserAuthentication" %>

<!DOCTYPE html>
<html>
   <head>
       <title>K-SHOP</title>
       <link rel="stylesheet" href="vendor/bootstrap-4.1/bootstrap.min.css">
   </head>
   
   <body>

   	   <%
   	       ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
   	   	   UserAuthentication thisUserAuth = 
   	   			cm.loginCtr.login(request.getParameter("phone_number"),request.getParameter("password"),request.getParameter("user_type"));
   	   	   if(thisUserAuth != null){
   	   		   if(thisUserAuth.getId() == -1){
   	   			   response.sendRedirect("login.jsp?login_info=logged");
   	   		   }
   	   		   else{
   	   		   	  session.setAttribute("user_auth", thisUserAuth);
   	   		   	  if(thisUserAuth.getUserType().equals("buyer")){
   	   		      	response.sendRedirect("index.jsp");
   	   		   	  }
   	   		   	  else{
   	   		   		response.sendRedirect("seller-personal.jsp"); 
   	   		   	  }
   	   		   }
   	   	   }
   	   	   else{
	   		   response.sendRedirect("login.jsp?login_info=fail");
   	   	   }
   	   %>
   </body>
</html>