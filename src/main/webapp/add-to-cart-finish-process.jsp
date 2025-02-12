<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.SellerOrientedItem" %>
<%@ page import = "dto.UserAuthentication" %>
<%@ page import = "dto.Cart" %>
<%@ page import = "dto.BuyerOrientedItem" %>
<%
    String info = "";
	String itemId = request.getParameter("item_id");
    ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
    ArrayList<SellerOrientedItem> items = cm.bc.getItemById(itemId);
    // if this item exist
    if(items != null){
    	//add it to cart
    	for(SellerOrientedItem item: items){  		
    		if(session.getAttribute("user_auth") != null){
    			String userId = String.valueOf(((UserAuthentication)session.getAttribute("user_auth")).getUserId());
    			// if add fail
    			if(!cm.addToCartCtr.AddToCart(userId, request.getParameter("item_id"), item.getName(), 
    					String.valueOf(item.getPrice()), request.getParameter("number"))){
    				// return fail info
    				info = "fail";
    			}
    		}
    		// if user is not login, return login reuqire info
    		else{
    			info = "login_required";
    		}
    	}
    	info = "success";
    }
    else{
    	// if this item does not exist return no_this_item
    	info = "no_this_item";
    }
    response.sendRedirect("item.jsp?info="+info);
%>