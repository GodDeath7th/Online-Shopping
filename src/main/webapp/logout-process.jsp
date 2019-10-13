<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	session.removeAttribute("user_auth");
    // if log out request is from success profile edit, back to index page with alert
    if(request.getParameter("from_url") != null){
		if(request.getParameter("from_url").equals("profile_edit")){
    		response.sendRedirect("index.jsp?info=re_login");
		}
    }
    // if common log out, simply back to index page
	else{
		response.sendRedirect("index.jsp");
	}
%>