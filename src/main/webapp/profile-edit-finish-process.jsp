<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.User" %>
<%@ page import = "dto.UserAuthentication" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
    String userId = String.valueOf(((UserAuthentication)session.getAttribute("user_auth")).getUserId());
    String username = request.getParameter("username");
    
    if(cm.editProfileCtr.editProfile(userId, username)){
    	response.sendRedirect("logout-process.jsp?info=re_login");
    }
    else{
    	response.sendRedirect("profile-edit.jsp?info=fail");
    }
%>