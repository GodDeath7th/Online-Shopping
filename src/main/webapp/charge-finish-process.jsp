<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.UserAuthentication" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
	String buyerId = String.valueOf(((UserAuthentication)session.getAttribute("user_auth")).getUserId());
    String money = request.getParameter("charge");
    // if charge balance success, to buyer personal page
    if(cm.chargeBalanceCtr.chargeBalance(buyerId, money)){
    	response.sendRedirect("buyer-personal.jsp?display=profile");
    }
    // otherwise back to charge page with fail infor displaying
    else{
    	response.sendRedirect("charge.jsp?info=fail");
    }
%>