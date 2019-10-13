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
	String itemName = request.getParameter("item_name");
	String price = request.getParameter("price");
	String stock = request.getParameter("stock");
	String description = request.getParameter("description");
	
	// if update an item success, to seller personal page
	if(cm.updateItemCtr.updateItem(itemId, itemName, price, stock, description)){
		response.sendRedirect("seller-personal.jsp?display=item");
	}
	// else back to item edit page
	else{
		response.sendRedirect("item-edit.jsp?info=fail");
	}
%>
