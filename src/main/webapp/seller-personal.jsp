<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import= "dto.UserAuthentication" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<script src="vendor/jquery-3.2.1.min.js"></script>
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <%
		// initialize controller manager at first so this manager can be accessd over whole application
		if(application.getAttribute("controller_manager") == null){
			ControllerManager cm = new ControllerManager();
			application.setAttribute("controller_manager", cm);
		}
    	String url = "";
    	if((UserAuthentication)session.getAttribute("user_auth") != null){
			if(((UserAuthentication)session.getAttribute("user_auth")).getUserType().equals("seller")){
				url = "#";
			}
			else{
	    		url = "index.jsp";
			}
    	}
	%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="<%=url%>">K-SHOP</a>
      	<div class= "collapse navbar-collapse">
      	<%	
      		if(session.getAttribute("user_auth") != null){
      			if(((UserAuthentication)session.getAttribute("user_auth")).getUserType().equals("buyer")){
      				out.print(((ControllerManager)application.getAttribute("controller_manager")).navbarCtr.setNavbarContent("buyer"));
      			}
      			else if(((UserAuthentication)session.getAttribute("user_auth")).getUserType().equals("seller")){
      				out.print(((ControllerManager)application.getAttribute("controller_manager")).navbarCtr.setNavbarContent("seller"));
      			}
      			else{}
      		}
      		else{
  				out.print(((ControllerManager)application.getAttribute("controller_manager")).navbarCtr.setNavbarContent("guest"));
      		}
      	%>
        </div>
    </nav>
	
	
	<div class = "contaienr" id = "personal-area" style = "width:300px;margin:50px auto">
	 <div class="btn-group">
	   <%	
	       //out.print(((ControllerManager)application.getAttribute("controller_manager")).displayCtr.getDisplay(request.getParameter("display"), ((UserAuthentication)session.getAttribute("user_auth")).getUserType()));
	   	   out.print(((ControllerManager)application.getAttribute("controller_manager")).displayCtr.getDisplay(request.getParameter("display"), "seller"));
	   %>
	 </div>
	</div>
	<%	
        if(request.getParameter("display") == null){
        	out.print(((ControllerManager)application.getAttribute("controller_manager")).getProfileCtr.getProfile(String.valueOf(((UserAuthentication)session.getAttribute("user_auth")).getUserId())));
        }
        else{
        	ControllerManager sellerCM = (ControllerManager)application.getAttribute("controller_manager");
			if(request.getParameter("display").equals("profile")){
				int userId = ((UserAuthentication)session.getAttribute("user_auth")).getUserId();
				out.print(sellerCM.getProfileCtr.getProfile(String.valueOf(userId)));
			}
			else if(request.getParameter("display").equals("item")){
				int sellerId = ((UserAuthentication)session.getAttribute("user_auth")).getUserId();
				out.print(sellerCM.getItemsBySellerIdctr.getItemsBySellerId(String.valueOf(sellerId)));
			}
			else if(request.getParameter("display").equals("order")){
				int sellerId = ((UserAuthentication)session.getAttribute("user_auth")).getUserId();
				out.print(sellerCM.getOrdersCtr.getOrders(String.valueOf(sellerId),false));
			}
        }
	%>	
</body>	
</html>