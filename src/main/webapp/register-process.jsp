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
   	       String username = request.getParameter("username");
   	       String password = request.getParameter("password");
   	       String phoneNumber = request.getParameter("phone_number");
   	       String userType = request.getParameter("user_type");
   	       String result = cm.registerCtr.register(username, password, phoneNumber, userType);
   	       // if register success, to log in page
   	   	   if(result.equals("success")){
   	   		response.sendRedirect("login.jsp?login_info=success");
   	   	   }
   	       // if same user information already registered, back to register page
   	   	   else if(result.equals("exist")){
	   		   response.sendRedirect("register.jsp?register_info=exist");
   	   	   }
   	       // if register fail, back to register page
   	   	   else if(result.equals("fail")){
	   		   response.sendRedirect("register.jsp?register_info=fail");
	   	   }
   	   %>
   </body>
</html>