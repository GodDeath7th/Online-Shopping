package controller;

import java.util.ArrayList;

import dto.SellerOrientedItem;

public class GetItemsByKeywordController extends Controller{
	// get items by keyword, which is search funciton
	public String getItemsByKeyword(String keyword){
		String htmlText = "";
		int number = 1;
		
		ArrayList<SellerOrientedItem> items =  bc.getItemsByKeyword(keyword);
		// return html to page
		if(items == null) {
			htmlText = "<div class = 'container' style = 'width:800px; margin:100px auto'><p align='center'>No mactch result.</p></div>";
		}
		else {
			htmlText = "<div class = 'container' style = 'width:800px; margin:100px auto'>";
			for(SellerOrientedItem item: items) {
				htmlText = htmlText + "<div class = 'container rounded border border-dark' style='margin:20px auto'>";
				htmlText = htmlText + "<p>Seller: "+item.getSellerName()+"</p>";
				htmlText = htmlText + "<p>Name: "+item.getName()+"</p>";
				htmlText = htmlText + "<p>Price: $"+item.getPrice()+"</p>";
				htmlText = htmlText + "<p>Stock: "+item.getStock()+"</p>";
				htmlText = htmlText + "<p>Description: "+item.getDescription()+"</p>";
				htmlText = htmlText + "<div class = 'row' style = 'margin:10px auto'>";
				htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'add-to-cart-process.jsp?item_id="+item.getId()+"'>Add Cart</a>";
				htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'send-message.jsp?to_name="+item.getSellerName()+"'>Send Message</a>";
				htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'item-comment.jsp?item_id="+item.getId()+"'>Comment</a>";
				htmlText = htmlText + "</div></div>";			
			}
			htmlText = htmlText+"</div>";
		}		
		return htmlText;
	}
}