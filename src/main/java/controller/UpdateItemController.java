package controller;

import dto.SellerOrientedItem;
import facade.SellerOrientedItemFacade;

public class UpdateItemController extends Controller{
	// update item information for a seller
	public boolean updateItem(String itemId, String itemName, String price, String stock, String description) {
		SellerOrientedItemFacade sellerItemFacade = new SellerOrientedItemFacade();
		sellerItemFacade.setSellerItem(Integer.parseInt(itemId), 0, "", itemName, Float.parseFloat(price), Integer.parseInt(stock), description);

		return bc.updateItem(sellerItemFacade.getSellerItemData());
	}
}
