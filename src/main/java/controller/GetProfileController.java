package controller;

import dto.Buyer;
import dto.Seller;
import dto.User;

public class GetProfileController extends Controller{
	// get profile of a user by giving user id and set display style
	public String getProfile(String userId) {
		String htmlText = "";
		User thisUser = bc.getProfile(Integer.parseInt(userId));
		if(thisUser == null) {
		}
		else {
			htmlText = htmlText + "<div class = 'container ' style = 'width:800px; margin:100px auto'>";
			htmlText = htmlText + "<div class = 'container rounded border border-dark' style='margin:20px auto'>";
			htmlText = htmlText + "<p>Username: "+thisUser.getUsername()+"</p>";
			htmlText = htmlText + "<p>Password: "+thisUser.getPassword()+"</p>";
			htmlText = htmlText + "<p>Phone Number: "+thisUser.getPhoneNumber()+"</p>";
			htmlText = htmlText + "<p>User Type: "+thisUser.getUserType()+"</p>";
			if(thisUser.getUserType().equals("buyer")) {
				Buyer thisBuyer = bc.getBuyerById(thisUser.getId());
				htmlText = htmlText + "<p>Balance: "+thisBuyer.getBalance()+"</p>";
				htmlText = htmlText + "<div class = 'row' style = 'margin:10px auto'>";
				htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'profile-edit-process.jsp?user_id="+thisUser.getId()+"'>Edit</a>";
				htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'charge-process.jsp?user_id="+thisUser.getId()+"'>Charge</a>";
				htmlText = htmlText + "</div></div>";			
				htmlText = htmlText + "</div>";
			}
			else if(thisUser.getUserType().equals("seller")){
				Seller thisSeller = bc.getSellerById(thisUser.getId());
				htmlText = htmlText + "<p>Income: "+thisSeller.getIncome()+"</p>";
				htmlText = htmlText + "<div class = 'row' style = 'margin:10px auto'>";
				htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'profile-edit-process.jsp?user_id="+thisUser.getId()+"'>Edit</a>";
				htmlText = htmlText + "</div></div>";			
				htmlText = htmlText + "</div>";
			}
		}
		return htmlText;
	}
}