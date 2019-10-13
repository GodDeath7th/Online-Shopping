<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.SellerOrientedItem" %>
<%@ page import = "dto.UserAuthentication" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<%
		// initialize controller manager at first so this manager can be accessd over whole application
		if(application.getAttribute("controller_manager") == null){
			ControllerManager cm = new ControllerManager();
			application.setAttribute("controller_manager", cm);
		}
	%>
	<script src="vendor/jquery-3.2.1.min.js"></script>
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="index.jsp">K-SHOP</a>
      	<div class= "collapse navbar-collapse">
      	<%
      		if(session.getAttribute("user_auth") != null){
      			if(((UserAuthentication)session.getAttribute("user_auth")).getUserType().equals("buyer")){
      				ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
      				out.print(cm.navbarCtr.setNavbarContent("buyer"));
      			}
      			else if(((UserAuthentication)session.getAttribute("user_auth")).getUserType().equals("seller")){
      				ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
      				out.print(cm.navbarCtr.setNavbarContent("seller"));
      			}
      			else{}
      		}
      		else{
      			ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
  				out.print(cm.navbarCtr.setNavbarContent("guest"));
      		}
      	%>
        </div>
    </nav>    
	
	<div class = "container" id = "order-preview" style = "width:800px;margin: 100px auto">
	 <h1>Order Preview</h1>
     <div class="container" id = "item-info">
        <p>Item information</p>
     	<%
     		ControllerManager cartCM = (ControllerManager)application.getAttribute("controller_manager");
	    	String buyerId = String.valueOf(((UserAuthentication)session.getAttribute("user_auth")).getUserId());
	    	out.print(cartCM.getCartCtr.getCart(buyerId, false));
	        Float totalPrice = cartCM.getCartCtr.getTotalPrice(buyerId);
     	%>
     </div>  
     <div class="container" id = "address">
        <p>Address</p>
	 	<%	
     		ControllerManager addrCM = (ControllerManager)application.getAttribute("controller_manager");
	    	String userId = String.valueOf(((UserAuthentication)session.getAttribute("user_auth")).getUserId());
	    	if(addrCM.getAddrsCtr.hasAddress(userId)){
	    		out.print(addrCM.getAddrsCtr.getAddress(userId, false));
	    	}else{
	    		response.sendRedirect("buyer-personal.jsp?display=address&info=no_address");
	    	}
     	%>
	 </div>
     <div class="container">
	  <p align = "center">Total: <%=totalPrice %></p>
  	 </div>
  	 <div class = "container" style = "width:100px;margin:50px auto"><a class = 'btn btn-success' href = 'checkout-process.jsp'>Check out</a>
  	 </div>
  	 <%
           if(request.getParameter("info") != null){
        	   if(request.getParameter("info").equals("no_enough_money")){
        	       out.println("<p style='color:red;''>Your balance is not enough!</p>");
        	   }
        	   else if(request.getParameter("info").equals("out_of_stock")){
           	       out.println("<p style='color:red;''>some goods out of stock !</p>");
           	   }
           }
       %>
    </div>

	
</body>	
</html>