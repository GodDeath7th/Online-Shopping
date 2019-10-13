<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
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
	<script src="vendor/jquery-3.2.1.min.js"></script>
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="<%=url%>">K-SHOP</a>
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
    
    <div class = "container" style = "width:800px;margin:100px auto">
     <h1>Add Item</h1>
     
     <form action = "item-add-process.jsp" method="post">
      <div class="form-group">
       <label >Item Name</label>
       <input type="text" class="form-control" name = "item_name" placeholder="Item name">
      </div>
      <div class="form-group">
       <label>Price</label>
       <input type="text" class="form-control" name = "price" placeholder="price">
      </div>
      <div class="form-group">
       <label>Stock</label>
       <input type="text" class="form-control" name = "stock" placeholder="stock">
      </div>
      <div class="form-group">
       <label>Description</label>
       <textarea class="form-control" name = "description" rows="10"></textarea>
       <small class="form-text text-muted">No more than 80 words.</small>
       <%
           if(request.getParameter("info") != null){
        	   if(request.getParameter("info").equals("fail")){
        	       out.println("<p style='color:red;''>Add item fail!</p>");
        	   }
           }
       %>
      </div>
      <button type="submit" class="btn btn-success">Add</button>
	 </form>
	</div>
</body>    
</html>