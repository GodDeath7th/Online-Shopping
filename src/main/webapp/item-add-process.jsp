<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="unitofwork.SellerOrientedItemUnitOfWork" %>
<%@ page import="dto.User" %>
<%@ page import="dto.SellerOrientedItem" %>
<%@ page import="dto.UserAuthentication" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.ControllerManager" %>

<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
	String sellerId = String.valueOf(((UserAuthentication)session.getAttribute("user_auth")).getUserId());
	String sellerName = cm.bc.getProfile(Integer.parseInt(sellerId)).getUsername();
	String itemName = request.getParameter("item_name");
	String price = request.getParameter("price");
	String stock = request.getParameter("stock");
	String description = request.getParameter("description");
    out.print(sellerId);
    out.print(sellerName);
    out.print(itemName);
    out.print(price);
    out.print(stock);
    out.print(description);
	if(cm.addItemCtr.addItem(sellerId, sellerName, itemName, price, stock, description)){
		response.sendRedirect("seller-personal.jsp?display=item");
	}
	else{
		response.sendRedirect("item-add.jsp?info=fail");
	}
%>
