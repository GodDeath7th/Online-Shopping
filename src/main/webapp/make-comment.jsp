<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.UserAuthentication" %>
<%@ page import = "dto.SellerOrientedItem" %>

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
		ControllerManager itemCM = (ControllerManager)application.getAttribute("controller_manager");
	    ArrayList<SellerOrientedItem> items = itemCM.bc.getItemById(request.getParameter("item_id"));
	    String itemName = items.get(0).getName();
	    int itemId = items.get(0).getId();
	    int userId = ((UserAuthentication)session.getAttribute("user_auth")).getUserId();
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
    
    <div class = "container" style = "width: 800px;margin:100px auto">
     <h1>Make comment</h1>
     <form action = "make-comment-process.jsp">
      <div class="form-group">
       <label >To <%=itemName%></label>
      </div>
      <div class="form-group">
       <label >Comment</label>
       <textarea class="form-control" name = "content" rows="10"></textarea>
       <small class="form-text text-muted">No more than 80 words.</small>
      </div>
      <%
           if(request.getParameter("info") != null){
        	   if(request.getParameter("info").equals("fail")){
        	       out.println("<p style='color:red;''>Make comment fail !</p>");
        	   }
           }
       %>
       <input type = "hidden" name = "item_id" value = "<%=itemId%>">
        <input type = "hidden" name = "item_name" value = "<%=itemName%>">
         <input type = "hidden" name = "user_id" value = "<%=userId%>">
      <button type="submit" class="btn btn-success">Make</button>
	 </form>
	</div>
</body>    
</html>