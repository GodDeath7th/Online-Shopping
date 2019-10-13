<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.UserAuthentication" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
    String userId = String.valueOf(((UserAuthentication)session.getAttribute("user_auth")).getUserId());
    String address = request.getParameter("address");
    String state = request.getParameter("state");
    String country = request.getParameter("country");
    String zip = request.getParameter("zip");
    // if add this address successfully, go to buyer personal page
	if(cm.addAddrCtr.addAddress(userId, address, state, country, zip)){
		response.sendRedirect("buyer-personal.jsp?display=address");
	}
    // otherwise back to address add page with displaying fail info
	else{
		response.sendRedirect("address-add.jsp?info=fail");
	}
%>