<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.UserAuthentication" %>
<%@ page import = "dto.Address" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
	String cartId = request.getParameter("cart_id");
	if(cm.removeFromCartCtr.removeFromCart(cartId)){
		response.sendRedirect("cart.jsp");
	}
	else{
		response.sendRedirect("cart.jsp");
	}
%>