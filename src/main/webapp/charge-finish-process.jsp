<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.UserAuthentication" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
	String buyerId = String.valueOf(((UserAuthentication)session.getAttribute("user_auth")).getUserId());
    String money = request.getParameter("charge");
    if(cm.chargeBalanceCtr.chargeBalance(buyerId, money)){
    	response.sendRedirect("buyer-personal.jsp?display=profile");
    }
    else{
    	response.sendRedirect("charge.jsp?info=fail");
    }
%>