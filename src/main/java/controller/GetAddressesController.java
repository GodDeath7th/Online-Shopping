package controller;

import java.util.ArrayList;

import dto.Address;

public class GetAddressesController extends Controller{
	public String getAddress(String userId, boolean enableOperation) {
		String htmlText = "";
		ArrayList<Address> thisUserAddresses = bc.getAddresses(Integer.parseInt(userId));
		if(thisUserAddresses == null) {
			htmlText = htmlText + "<div class = 'container' style = 'width:800px; margin:100px auto'><p align='center'>No Address.</p></div>";
			if(enableOperation) {
				htmlText = htmlText + "<div class = 'container' style = 'width:100px; margin:100px auto'><a class = 'btn btn-success' href='address-add.jsp'>Add</a></div>";
			}
		}
		else {
			if(enableOperation)
				htmlText = htmlText + "<div class = 'container ' style = 'width:800px; margin:100px auto'>";
			for(Address thisUserEachAddress: thisUserAddresses) {
				htmlText = htmlText + "<div class = 'container rounded border border-dark' style='margin:20px auto'>";
				htmlText = htmlText + "<p>Address: "+thisUserEachAddress.getAddress()+"</p>";
				htmlText = htmlText + "<p>Sate :"+thisUserEachAddress.getState()+"</p>";
				htmlText = htmlText + "<p>Country :"+thisUserEachAddress.getCountry()+"</p>";
				htmlText = htmlText + "<p>Zip :"+thisUserEachAddress.getZip()+"</p>";
				if(enableOperation) {
					htmlText = htmlText + "<div class = 'row' style = 'margin:10px auto'>";
					htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'address-edit-process.jsp?user_id="+thisUserEachAddress.getUserId()+"'>Edit</a>";
					htmlText = htmlText + "<a class = 'btn btn-danger' style = 'margin:5px' href = 'address-delete-process.jsp?user_id="+thisUserEachAddress.getUserId()+"'>Delete</a>";
					htmlText = htmlText + "</div>";
				}
				htmlText = htmlText + "</div>";
			}
			htmlText = htmlText + "</div>";
		}
		return htmlText;
	}
	
	public boolean hasAddress(String userId) {
		ArrayList<Address> thisUserAddresses = bc.getAddresses(Integer.parseInt(userId));
		if(thisUserAddresses == null) {
			return false;
		}
		else {
			return true;	
		}
	}
}
