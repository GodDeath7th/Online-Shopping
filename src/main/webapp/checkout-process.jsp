<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.UserAuthentication" %>
<%@ page import = "dto.Buyer" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
	int userId = ((UserAuthentication)session.getAttribute("user_auth")).getUserId();
	String result = cm.purchaseCtr.purchase(String.valueOf(userId));
	// if check out success, to buyer personal page
	if(result.equals("success")){
		response.sendRedirect("buyer-personal.jsp?display=order");
	}
	// if no enough money, back to check out page to display no enough money
	else if(result.equals("no_enough_money")){
		response.sendRedirect("checkout.jsp?info=no_enough_money");
	}
	// if any good in cart out of stock, back to check out page to display some good out of stock
	else if(result.equals("out_of_stock")){
		response.sendRedirect("checkout.jsp?info=out_of_stock");
	}
	
%>