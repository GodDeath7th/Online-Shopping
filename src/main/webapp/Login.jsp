<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="controller.UserLogin" %>

<!DOCTYPE html>
<html>
   <head>
       <title>K-SHOP</title>
       <link rel="stylesheet" href="vendor/bootstrap-4.1/bootstrap.min.css">
   </head>
   
   <body>
   	   <form action="login-process.jsp" method="post">
        username:<input type="text" name="username"/></br>
   	    password:<input type="password" name="password"/></br>
   	    <button type="submit">login</button></br>
       </form></br>
       username: kevinzzz , password: zzz1994
   	   <%
   	   	   try{
   	       	   if(((String)session.getAttribute("login_error")).equals("true")){
   	       		   out.println("</br>");
   	    	       out.println("wrong username/password pair !");
   	    	       session.removeAttribute("login_error");
   	           }
   	   	   }catch(Exception e){}
   	   %>
   </body>
</html>