<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.Buyer" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
    int userId = Integer.parseInt(request.getParameter("user_id"));
    Buyer buyer = cm.bc.getBuyerById(userId);
    // get balance for pre-fill in blank
    if(buyer != null){
    	String url = "charge.jsp?";
    	url = url + "balance=" + buyer.getBalance();
    	
    	response.sendRedirect(url);
    }
%>