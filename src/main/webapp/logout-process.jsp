<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	session.removeAttribute("user_auth");
    response.sendRedirect("index.jsp?info=re_login");
%>