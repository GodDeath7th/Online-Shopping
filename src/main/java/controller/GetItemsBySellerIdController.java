package controller;

import java.util.ArrayList;

import dto.SellerOrientedItem;

public class GetItemsBySellerIdController extends Controller{
	// get all items selled by an seller
	public String getItemsBySellerId(String sellerId){
		String htmlText = "";
		int number = 1;
		
		ArrayList<SellerOrientedItem> items =  bc.getItemsBySellerId(sellerId);
		// return html to page
		if(items == null) {
			htmlText = "<div class = 'container' style = 'width:800px; margin:100px auto'><p align='center'>No added item.</p></div>";
			htmlText = htmlText + "<div class = 'container' style = 'width:100px; margin:100px auto'><a class = 'btn btn-success' href='item-add.jsp'>Add</a></div>";
		}
		else {
			htmlText = "<div class = 'container' style = 'width:800px; margin:100px auto'>";
			for(SellerOrientedItem item: items) {
				htmlText = htmlText + "<div class = 'container rounded border border-dark' style='margin:20px auto'>";
				htmlText = htmlText + "<p>Name: "+item.getName()+"</p>";
				htmlText = htmlText + "<p>Price: $"+item.getPrice()+"</p>";
				htmlText = htmlText + "<p>Stock: "+item.getStock()+"</p>";
				htmlText = htmlText + "<div class = 'row' style = 'margin:10px auto'>";
				htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'item-comment.jsp?item_id="+item.getId()+"'>To comment</a>";
				htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'item-edit-process.jsp?item_id="+item.getId()+"'>Edit</a>";
				htmlText = htmlText + "<a class = 'btn btn-danger' style = 'margin:5px' href = 'item-delete-process.jsp?item_id="+item.getId()+"'>Delete</a>";
				htmlText = htmlText + "</div></div>";			
			}
			htmlText = htmlText+"</div>";
			htmlText = htmlText + "<div class = 'container' style = 'width:100px; margin:100px auto'><a class = 'btn btn-success' href='item-add.jsp'>Add</a></div>";
		}		
		return htmlText;
	}
}
