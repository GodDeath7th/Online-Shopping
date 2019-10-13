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
    
    <div class = "container" style = "width: 800px;margin:100px auto">
     <h1>Login</h1>
     <form action = "login-process.jsp">
      <div class="form-group">
       <label >Phone Number</label>
       <input type="text" class="form-control" name = "phone_number" placeholder="Phone number">
       <small id="emailHelp" class="form-text text-muted">We'll never share your phone number with anyone else.</small>
      </div>
      <div class="form-group">
       <label>Password</label>
       <input type="password" class="form-control" name = "password" placeholder="Password">
      </div>
      <div class="form-group">
       <label>User Type</label>
       <select name = "user_type" class="form-control">
        <option>seller</option>
        <option>buyer</option>
       </select>
       <%
           if(request.getParameter("login_info") != null){
        	   if(request.getParameter("login_info").equals("fail")){
        	       out.println("<p style='color:red;''>Your login information is incorrect !</p>");
        	   }
        	   else if(request.getParameter("login_info").equals("logged")){
           	       out.println("<p style='color:red;''>It has already logged !</p>");
           	   }
        	   else if(request.getParameter("login_info").equals("success")){
           	       out.println("<p style='color:green;''>Successful register! you can log in now !</p>");
           	   }
           }
       %>
      </div>
      <button type="submit" class="btn btn-success">Login</button>
	 </form>
	</div>
</body>    
</html>