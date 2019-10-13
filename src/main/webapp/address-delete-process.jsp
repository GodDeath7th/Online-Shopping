<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.UserAuthentication" %>
<%@ page import = "dto.Address" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
	ArrayList<Address> addresses = cm.bc.getAddresses(Integer.parseInt(request.getParameter("user_id")));
	String addrId = String.valueOf(addresses.get(0).getId());
	out.print(addrId);
	if(cm.deleteAddrCtr.deleteAddress(addrId)){
		response.sendRedirect("buyer-personal.jsp?display=address");
	}
	else{
		response.sendRedirect("buyer-personal.jsp?display=address");
	}
%>