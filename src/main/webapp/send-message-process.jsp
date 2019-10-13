<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.Message" %>
<%@ page import = "dto.UserAuthentication" %>
<%@ page import = "dto.User" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
    String fromName = (cm.bc.getProfile(((UserAuthentication)session.getAttribute("user_auth")).getUserId())).getUsername();
    User user = new User();
    user.setUsername(request.getParameter("to_name"));
    if(cm.bc.isUserExisted(user)){
    	String toName = request.getParameter("to_name");
    	String content = request.getParameter("content");
   		// if user send to existed and messgae send successfully, to message page
    	if(cm.sendMsgCtr.sendMessage(fromName, toName, content)){
    		response.sendRedirect("message.jsp?display=send_message");
    	}
   		// otherwise back to send message page
    	else{
    		response.sendRedirect("send-message.jsp?info=fail");
    	}
    }
    else{
    	// if user send to not existed, back to send message page
    	response.sendRedirect("send-message.jsp?info=fail");
    }
    
%>