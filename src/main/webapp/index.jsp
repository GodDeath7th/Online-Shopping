<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import= "controller.ControllerManager" %>
<%@ page import = "dto.UserAuthentication" %>

<!DOCTYPE html>
<html lang="en">

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
    	if(request.getParameter("info") != null){
			if(request.getParameter("info").equals("re_login")){
				out.print("<script>alert('Edit Profile Success! Please re-login.')</script>");
			}
		}
	%>
	
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
	
	<div class = "container" id = "category">
	 <h1>What We Sell</h1>
	 <div class = "row" id = "first_row" style = "margin:40px auto">
	  <div class="card" style="width: 20rem; margin:1px auto">
       <img class="card-img-top" src="image/eletronic-product.jpg" alt="Card image cap">
       <div class="card-body">
        <h5 class="card-title">High-tech Products</h5>
        <p class="card-text">High-tech is new fashion, start your smart life now.</p>
       </div>
      </div>
	  <div class="card" style="width: 20rem; margin:1px auto">
       <img class="card-img-top" src="image/clothes.jpg" alt="Card image cap">
       <div class="card-body">
        <h5 class="card-title">Clothes</h5>
        <p class="card-text">You are what you wear, get yourself gorgeous here.</p>
       </div>
      </div>
	  <div class="card" style="width: 20rem; margin:1px auto">
       <img class="card-img-top" src="image/cosmetics.jpg" alt="Card image cap">
       <div class="card-body">
        <h5 class="card-title">Cosmetics</h5>
        <p class="card-text">Being attractive, being elegant, being beautiful.</p>
       </div>
	  </div>	 
	 </div>
	 <div class = "row" id = "second_row" style = "margin:20px auto">
	  <div class="card" style="width: 20rem; margin:1px auto">
       <img class="card-img-top" src="image/food.jpg" alt="Card image cap">
       <div class="card-body">
        <h5 class="card-title">Food</h5>
        <p class="card-text">Delicious food makes every energetic day. </p>
       </div>
	  </div>
	  <div class="card" style="width: 20rem; margin:1px auto">
       <img class="card-img-top" src="image/drink.jpg" alt="Card image cap">
       <div class="card-body">
        <h5 class="card-title">Drink</h5>
        <p class="card-text">Enjoy a sunshine afternoon with drink you love.</p>
       </div>
	  </div>
	  <div class="card" style="width: 20rem; margin:1px auto">
       <img class="card-img-top" src="image/explore.jpg" alt="Card image cap">
       <div class="card-body">
        <h5 class="card-title">Others</h5>
        <p class="card-text">Search and find what you want !</p>
        <a href='item.jsp' class='btn btn-primary'>Explore</a>
       </div>
	  </div>
	 </div>
	</div>
	<%
		
	%>
</body>

</html>