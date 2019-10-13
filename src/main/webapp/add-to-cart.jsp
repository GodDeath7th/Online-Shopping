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
    
	
	<!-- set style of navigation bar -->
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
    
    <div class = "container" style = "width: 800px;margin:100px auto">
     <h1>Add to cart</h1>
     <%
     	ControllerManager cm = ((ControllerManager)application.getAttribute("controller_manager"));
 		out.print(cm.getItemByIdCtr.getItemById(request.getParameter("item_id"), false));
     %>
     <form action = "add-to-cart-finish-process.jsp">
      <div class="form-group">
       <label >Number:</label>
       <input type="hidden" class="form-control" name = "item_id" value="<%=request.getParameter("item_id") %>">
       <input type="text" class="form-control" name = "number" placeholder="number">
       <small class="form-text text-muted">No more than stock displayed.</small>
      </div>
       <%
           if(request.getParameter("info") != null){
        	   if(request.getParameter("info").equals("fail")){
        	       out.println("<p style='color:red;''>Add to cart fail!</p>");
        	   }
           }
       %>
      <button type="submit" style = "margin:5px auto" class="btn btn-success">Add to cart</button>
	 </form>
	</div>
</body>    
</html>