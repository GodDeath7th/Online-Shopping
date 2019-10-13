<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="unitofwork.SellerOrientedItemUnitOfWork" %>
<%@ page import="dto.User" %>
<%@ page import="dto.SellerOrientedItem" %>
<%@ page import="dto.UserAuthentication" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.ControllerManager" %>

<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
	String itemId = request.getParameter("item_id");

	if(cm.deleteItemCtr.deleteItem(itemId)){
		response.sendRedirect("seller-personal.jsp?display=item");
	}
	else{
		response.sendRedirect("seller-personal.jsp?display=item");
	}
%>
