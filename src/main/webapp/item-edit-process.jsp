<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="unitofwork.SellerOrientedItemUnitOfWork" %>
<%@ page import="dto.User" %>
<%@ page import="dto.SellerOrientedItem" %>
<%@ page import="dto.UserAuthentication" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.ControllerManager" %>

<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
    ArrayList<SellerOrientedItem> items = cm.bc.getItemById(request.getParameter("item_id"));
	if(items == null){
    	
    }
    else{
    	String url = "item-edit.jsp?";
    	url = url + "item_id=" + items.get(0).getId() + "&";
    	url = url + "item_name=" + items.get(0).getName() + "&";
    	url = url + "price=" + items.get(0).getPrice() + "&";
    	url = url + "stock=" + items.get(0).getStock() + "&";
    	url = url + "description=" + items.get(0).getDescription();
    	
    	response.sendRedirect(url);
    }

%>
