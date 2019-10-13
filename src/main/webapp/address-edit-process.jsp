<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.UserAuthentication" %>
<%@ page import = "dto.Address" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
    ArrayList<Address> addresses = cm.bc.getAddresses(Integer.parseInt(request.getParameter("user_id")));
    if(addresses == null){
    	
    }
    else{
    	String url = "address-edit.jsp?";
    	url = url + "address_id=" + addresses.get(0).getId() + "&";
    	url = url + "address=" + addresses.get(0).getAddress() + "&";
    	url = url + "state=" + addresses.get(0).getState() + "&";
    	url = url + "country=" + addresses.get(0).getCountry() + "&";
    	url = url + "zip=" + addresses.get(0).getZip();
    	
    	response.sendRedirect(url);
    }
%>