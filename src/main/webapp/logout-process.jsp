<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	session.removeAttribute("user_auth");
	if(request.getParameter("from_url").equals("profile_edit.jsp")){
    	response.sendRedirect("index.jsp?info=re_login");
	}
	else{
		response.sendRedirect("index.jsp");
	}
%>