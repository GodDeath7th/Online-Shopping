<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.User" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
    int userId = Integer.parseInt(request.getParameter("user_id"));
    User user = cm.bc.getProfile(userId);
    if(user != null){
    	String url = "profile-edit.jsp?";
    	url = url + "username=" + user.getUsername() + "&";
    	url = url + "password=" + user.getPassword() + "&";
    	url = url + "phone_number=" + user.getPhoneNumber() + "&";
    	url = url + "user_type=" + user.getUserType();
    	
    	response.sendRedirect(url);
    }
%>