<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.UserAuthentication" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
	if(cm.deleteCommentCtr.deleteComment(request.getParameter("comment_id"))){
		response.sendRedirect("buyer-personal.jsp?display=comment");
	}
	else{
		response.sendRedirect("buyer-personal.jsp?display=comment");
	}
%>