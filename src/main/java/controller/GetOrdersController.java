package controller;

import java.util.ArrayList;

import dto.Order;

public class GetOrdersController extends Controller{
	// get all orders of a user, if it is buyer to get them, set enableOperation true to allow user delete orders, if it is
	// seller to get them, set it false to prohibit delete
	public String getOrders(String userId, boolean enableOperation) {
		String htmlText = "";
		ArrayList<Order> thisUserOrders = bc.getOrders(Integer.parseInt(userId)); 
		if(thisUserOrders == null) {
			htmlText = htmlText + "<div class = 'container' style = 'width:800px; margin:100px auto'><p align='center'>No orders.</p></div>";
		}
		else {
			for(Order thisUserEachOrder: thisUserOrders) {
				htmlText = htmlText + "<div class = 'container border border-dark rounded' style = 'margin:20px auto'>";
				htmlText = htmlText + "<p>Item name:"+thisUserEachOrder.getItemName()+"</p>";
				htmlText = htmlText + "<p>Total price:"+thisUserEachOrder.getTotalPrice()+"</p>";
				htmlText = htmlText + "<p>Date:"+thisUserEachOrder.getDate()+"</p>";
				htmlText = htmlText + "<p>Address:"+thisUserEachOrder.getAddress().getAddress()+"</p>";
				htmlText = htmlText + "<p>State:"+thisUserEachOrder.getAddress().getState()+"</p>";
				htmlText = htmlText + "<p>Country:"+thisUserEachOrder.getAddress().getCountry()+"</p>";
				htmlText = htmlText + "<p>Zip:"+thisUserEachOrder.getAddress().getZip()+"</p>";
				if(enableOperation) {
					htmlText = htmlText + "<div class = 'row' style = 'margin:10px auto'>";
					htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'make-comment.jsp?item_id="+thisUserEachOrder.getItemId()+"'>Make comment</a>";
					//htmlText = htmlText + "<a class = 'btn btn-danger' style = 'margin:5px' href = 'delete_order_process.jsp?order_id="+thisUserEachOrder.getId()+"'>Delete</a>";
					htmlText = htmlText + "</div>";			
				}
				
				htmlText = htmlText + "</div>";
			}
		}
		return htmlText;
	}
}
