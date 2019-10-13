package controller;

import java.util.ArrayList;

import dto.SellerOrientedItem;

public class GetItemByIdController extends Controller{
	// get an item by its id and set display style to front end
	public String getItemById(String itemId, boolean enableOperationButton) {
		String htmlText = "";
		ArrayList<SellerOrientedItem> items = bc.getItemById(itemId);
		// return html to page
		if(items == null) {
			htmlText = "<p align='center'>No mactch result.</p>";
		}
		else {
			htmlText = "<div class = 'container' style = 'width:800px; margin:0px auto'>";
			for(SellerOrientedItem item: items) {
				htmlText = htmlText + "<div class = 'container rounded border border-dark' style='margin:20px auto'>";
				htmlText = htmlText + "<p>Seller: "+item.getSellerName()+"</p>";
				htmlText = htmlText + "<p>Name: "+item.getName()+"</p>";
				htmlText = htmlText + "<p>Price: $"+item.getPrice()+"</p>";
				htmlText = htmlText + "<p>Stock: "+item.getStock()+"</p>";
				htmlText = htmlText + "<p>Description: "+item.getDescription()+"</p>";
				if(enableOperationButton) {
					htmlText = htmlText + "<div class = 'row' style = 'margin:10px auto'>";
					htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'add-to-cart-process.jsp?item_id="+item.getId()+"'>Add Cart</a>";
					htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'checkout.jsp?item_id="+item.getId()+"'>Buy</a>";
					htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'item-comment.jsp?item_id="+item.getId()+"'>Comment</a>";
					htmlText = htmlText + "</div></div>";
				}
			}
		}		
		return htmlText;
	}
}
