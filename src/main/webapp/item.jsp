<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.SellerOrientedItem" %>
<%@ page import= "dto.UserAuthentication" %>

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
		if(request.getParameter("info") != null){
			if(request.getParameter("info").equals("login_required")){
				out.print("<script>alert('Please log in first!')</script>");
			}
			else if(request.getParameter("info").equals("fail")){
				out.print("<script>alert('Add fail!')</script>");
			}
			else if(request.getParameter("info").equals("success")){
				out.print("<script>alert('Add Success! Check in cart. ')</script>");
			}
			else if(request.getParameter("info").equals("no_this_item")){
				out.print("<script>alert('This product is unavailable!')</script>");
			}
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
	
	<form action = "item.jsp">
	<div class = "container" id = "search-area" style = "margin: 100px auto">
     <div class="input-group input-group-lg">
      <input type="text" class="form-control" placeholder="The goods you want to buy ..." name = "range">
      <div class="input-group-append">
       <button class="btn btn-success" type="submit">Search</button>
      </div>
     </div>  
	</div>
	</form>
	
	<div class = "contaienr" id = "items">
	 <% 
	 	if(request.getParameter("range") == null){
	 		ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
	 		out.print(cm.getAllItemsCtr.getAllItems());
	 	}
	 	else{
	 		ControllerManager cm = (ControllerManager)application.getAttribute("controller_manager");
	 		out.print(cm.getItemsByKeyCtr.getItemsByKeyword(request.getParameter("range")));
	 	}
     %>
	</div>
</body>	
</html>