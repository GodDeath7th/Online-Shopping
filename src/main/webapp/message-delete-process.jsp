<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.UserAuthentication" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
	if(cm.deleteMsgCtr.deleteMessage(request.getParameter("message_id"))){
		response.sendRedirect("message.jsp?display="+request.getParameter("from_url"));
	}
	else{
		response.sendRedirect("message.jsp?display="+request.getParameter("from_url"));
	}
%>