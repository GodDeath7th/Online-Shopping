package controller;

public class NavbarController extends Controller{
	public String setNavbarContent(String userType) {
		String htmlText = "";
		if(userType.equals("buyer")) {
			htmlText = htmlText + "<ul class='navbar-nav'>";
		    htmlText = htmlText + "<li class = 'nav-item'><a class = 'nav-link' href='buyer-personal.jsp'>Personal</a></li>";
		    htmlText = htmlText + "<li class = 'nav-item'><a class = 'nav-link' href='cart.jsp'>Cart</a></li>";
		    htmlText = htmlText + "<li class = 'nav-item'><a class = 'nav-link' href='message.jsp'>Message</a></li>";
		    htmlText = htmlText + "<li class = 'nav-item'><a class = 'nav-link' href='logout-process.jsp'>Log out</a></li>";
		    htmlText = htmlText + "</ul>";
		}
		else if(userType.equals("seller")) {
			htmlText = htmlText + "<ul class='navbar-nav'>";
		    htmlText = htmlText + "<li class = 'nav-item'><a class = 'nav-link' href='seller-personal.jsp'>Personal</a></li>";
		    htmlText = htmlText + "<li class = 'nav-item'><a class = 'nav-link' href='message.jsp'>Message</a></li>";
		    htmlText = htmlText + "<li class = 'nav-item'><a class = 'nav-link' href='logout-process.jsp'>Log out</a></li>";
		    htmlText = htmlText + "</ul>";
		}
		else if(userType.equals("guest")) {	
		    htmlText = htmlText + "<ul class='navbar-nav'>";
		    htmlText = htmlText + "<li class = 'nav-item'><a class = 'nav-link' href='login.jsp'>Log in</a></li>";
		    htmlText = htmlText + "<li class = 'nav-item'><a class = 'nav-link' href='register.jsp'>register</a></li>";
		    htmlText = htmlText + "</ul>";
		}
		else {			
		}
		
		return htmlText;
	}
}
