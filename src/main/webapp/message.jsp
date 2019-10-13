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
	
	
	<div class = "contaienr" id = "personal-area" style = "width:200px;margin:50px auto">
	 <div class="btn-group">
	   <%	
	       //out.print(((ControllerManager)application.getAttribute("controller_manager")).displayCtr.getDisplay(request.getParameter("display"), ((UserAuthentication)session.getAttribute("user_auth")).getUserType()));
	   	   out.print(((ControllerManager)application.getAttribute("controller_manager")).displayCtr.getDisplay(request.getParameter("display"), "message"));
	   %>
	 </div>
	</div>
	<%	
		ControllerManager nameCM = (ControllerManager)application.getAttribute("controller_manager");
		String username = nameCM.bc.getProfile(((UserAuthentication)session.getAttribute("user_auth")).getUserId()).getUsername();
        if(request.getParameter("display") == null){
        	out.print(((ControllerManager)application.getAttribute("controller_manager")).getSendMsgCtr.GetSendMessages(username));
        }
        else{     	
			if(request.getParameter("display").equals("send_message")){
				out.print(nameCM.getSendMsgCtr.GetSendMessages(username));
			}
			else if(request.getParameter("display").equals("receive_message")){
				out.print(nameCM.getRecvMsgCtr.GetReceiveMessages(username));
			}
        }
	%>	
</body>	
</html>