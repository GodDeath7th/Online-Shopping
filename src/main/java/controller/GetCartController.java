package controller;

import java.util.ArrayList;

import dto.Cart;

public class GetCartController extends Controller{
	public String getCart(String buyerId, boolean enableOperation) {
		String htmlText = "";
		ArrayList<Cart> thisBuyerCarts = bc.getCart(Integer.parseInt(buyerId));
		if(thisBuyerCarts == null) {
			htmlText = "<div class = 'container' style = 'width:800px; margin:100px auto'><p align='center'>No product in cart.</p></div>";
		}
		else {
			for(Cart thisBuyerEachCart: thisBuyerCarts) {
				htmlText = htmlText + "<div class = 'container border border-dark rounded' style='margin:20px auto'>";
				htmlText = htmlText + "<p>Name:"+thisBuyerEachCart.getBuyerItem().getName()+"</p>";
				htmlText = htmlText + "<p>Price For Each:"+thisBuyerEachCart.getBuyerItem().getPrice()+"</p>";
				htmlText = htmlText + "<p>Number:"+thisBuyerEachCart.getBuyerItem().getNumber()+"</p>";
				htmlText = htmlText + "<p>Total Price:"+thisBuyerEachCart.getBuyerItem().getNumber()*thisBuyerEachCart.getBuyerItem().getPrice()+"</p>";
				if(enableOperation) {
					htmlText = htmlText + "<a class = 'btn btn-danger' style = 'margin:5px' href = 'cart-delete-process.jsp?cart_id="+thisBuyerEachCart.getId()+"'>Remove</a>";
				}
				htmlText = htmlText + "</div>";
			}
			if(enableOperation) {
				htmlText = htmlText + "<div class = 'container' style = 'width:100px; margin:100px auto'><a class = 'btn btn-success' href = 'checkout.jsp'>Check out</a></div>";
			}
		}
		return htmlText;
	}
	
	public Float getTotalPrice(String buyerId) {
		Float totalPrice = Float.parseFloat("0");
		ArrayList<Cart> thisBuyerCarts = bc.getCart(Integer.parseInt(buyerId));
		if(thisBuyerCarts == null) {}
		else {
			for(Cart thisBuyerEachCart: thisBuyerCarts) {
				totalPrice = totalPrice + thisBuyerEachCart.getBuyerItem().getPrice()*thisBuyerEachCart.getBuyerItem().getNumber();
			}
		}
		return totalPrice;
	}
}