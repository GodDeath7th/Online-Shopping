<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.Message" %>
<%@ page import = "dto.UserAuthentication" %>
<%@ page import = "dto.User" %>
<%
	ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
    String userId = request.getParameter("user_id");
    String username = (cm.bc.getProfile(Integer.parseInt(userId))).getUsername();
    String itemId = request.getParameter("item_id");
    String itemName = request.getParameter("item_name");
    String content = request.getParameter("content");
    // if make comment success, to item comment page
    if(cm.makeCommentCtr.makeComment(userId, username, itemId, itemName, content)){
    	response.sendRedirect("item-comment.jsp?item_id="+itemId);
    }
    // otherwise, back to make comment page
    else{
    	response.sendRedirect("make-comment.jsp?info=fail");
    }
    
%>