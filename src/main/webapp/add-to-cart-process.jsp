<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.SellerOrientedItem" %>
<%@ page import = "java.util.ArrayList" %>
<%
	if(session.getAttribute("user_auth") == null){
		response.sendRedirect("item.jsp?info=login_required");
	}
	else{
		response.sendRedirect("add-to-cart.jsp?item_id="+request.getParameter("item_id"));
	}
%>