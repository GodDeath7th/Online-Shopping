package controller;

import dto.SellerOrientedItem;

public class DeleteItemController extends Controller{
	public boolean deleteItem(String itemId) {
		// delete item by giving its id in database
		SellerOrientedItem thisItem = new SellerOrientedItem();
		thisItem.setId(Integer.parseInt(itemId));
		return bc.deleteItem(thisItem);
	}
}
