package controller;

public class DisplayController  extends Controller{
	public String getDisplay(String display, String type){
		String htmlText = "";
		if(type.equals("buyer")) {
			if(display == null || display.equals("profile")) {
				htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=profile'>";
				htmlText = htmlText + "<button type='button' class=' btn btn-success btn-lg'>Profile</button>";
				htmlText = htmlText + "</a>";
				htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=address'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Address</button>";
	    		htmlText = htmlText + "</a>";
	    		htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=order'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Order</button>";
	    		htmlText = htmlText + "</a>";
	    		htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=comment'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Comment</button>";
	    		htmlText = htmlText + "</a>";
			}
			else if(display.equals("address")) {
				htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=profile'>";
				htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Profile</button>";
				htmlText = htmlText + "</a>";
				htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=address'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-success btn-lg'>Address</button>";
	    		htmlText = htmlText + "</a>";
	    		htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=order'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Order</button>";
	    		htmlText = htmlText + "</a>";
	    		htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=comment'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Comment</button>";
	    		htmlText = htmlText + "</a>";
			}
			else if(display.equals("order")) {
				htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=profile'>";
				htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Profile</button>";
				htmlText = htmlText + "</a>";
				htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=address'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Address</button>";
	    		htmlText = htmlText + "</a>";
	    		htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=order'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-success btn-lg'>Order</button>";
	    		htmlText = htmlText + "</a>";
	    		htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=comment'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Comment</button>";
	    		htmlText = htmlText + "</a>";
			}
			else if(display.equals("comment")) {
				htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=profile'>";
				htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Profile</button>";
				htmlText = htmlText + "</a>";
				htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=address'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Address</button>";
	    		htmlText = htmlText + "</a>";
	    		htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=order'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Order</button>";
	    		htmlText = htmlText + "</a>";
	    		htmlText = htmlText + "<a href = 'buyer-personal.jsp?display=comment'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-success btn-lg'>Comment</button>";
	    		htmlText = htmlText + "</a>";
			}
			else {}
		}
		else if(type.equals("seller")) {
			if(display == null || display.equals("profile")) {
				htmlText = htmlText + "<a href = 'seller-personal.jsp?display=profile'>";
				htmlText = htmlText + "<button type='button' class=' btn btn-success btn-lg'>Profile</button>";
				htmlText = htmlText + "</a>";
				htmlText = htmlText + "<a href = 'seller-personal.jsp?display=item'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Item</button>";
	    		htmlText = htmlText + "</a>";
	    		htmlText = htmlText + "<a href = 'seller-personal.jsp?display=order'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Order</button>";
	    		htmlText = htmlText + "</a>";
			}
			else if(display.equals("item")) {
				htmlText = htmlText + "<a href = 'seller-personal.jsp?display=profile'>";
				htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Profile</button>";
				htmlText = htmlText + "</a>";
				htmlText = htmlText + "<a href = 'seller-personal.jsp?display=item'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-success btn-lg'>Item</button>";
	    		htmlText = htmlText + "</a>";
	    		htmlText = htmlText + "<a href = 'seller-personal.jsp?display=order'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Order</button>";
	    		htmlText = htmlText + "</a>";
			}
			else if(display.equals("order")) {
				htmlText = htmlText + "<a href = 'seller-personal.jsp?display=profile'>";
				htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Profile</button>";
				htmlText = htmlText + "</a>";
				htmlText = htmlText + "<a href = 'seller-personal.jsp?display=item'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Item</button>";
	    		htmlText = htmlText + "</a>";
	    		htmlText = htmlText + "<a href = 'seller-personal.jsp?display=order'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-success btn-lg'>Order</button>";
	    		htmlText = htmlText + "</a>";
			}
			else{}
		}
		else if(type.equals("message")) {
			if(display == null || display.equals("send_message")) {
				htmlText = htmlText + "<a href = 'message.jsp?display=send_message'>";
				htmlText = htmlText + "<button type='button' class=' btn btn-success btn-lg'>Send</button>";
				htmlText = htmlText + "</a>";
				htmlText = htmlText + "<a href = 'message.jsp?display=receive_message'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Receive</button>";
	    		htmlText = htmlText + "</a>";
			}
			else if(display.equals("receive_message")) {
				htmlText = htmlText + "<a href = 'message.jsp?display=send_message'>";
				htmlText = htmlText + "<button type='button' class=' btn btn-light btn-lg'>Send</button>";
				htmlText = htmlText + "</a>";
				htmlText = htmlText + "<a href = 'message.jsp?display=receive_message'>";
	    		htmlText = htmlText + "<button type='button' class=' btn btn-success btn-lg'>Receive</button>";
	    		htmlText = htmlText + "</a>";
			}
			else{}
		}
		else {}
		return htmlText;
	}
}
