<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.UserAuthentication" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
    String addrId = request.getParameter("address_id");
    String address = request.getParameter("address");
    String state = request.getParameter("state");
    String country = request.getParameter("country");
    String zip = request.getParameter("zip");
	if(cm.updateAddrCtr.updateAddress(addrId, address, state, country, zip)){
		response.sendRedirect("buyer-personal.jsp?display=address");
	}
	else{
		response.sendRedirect("address-edit.jsp?info=fail");
	}
%>