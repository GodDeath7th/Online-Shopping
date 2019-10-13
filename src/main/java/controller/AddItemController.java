package controller;

import facade.SellerOrientedItemFacade;

public class AddItemController extends Controller{
	// add item for a seller
	public boolean addItem(String sellerId, String sellerName, String itemName, String price, String stock, String description) {
		try {
			// generate item facade
			SellerOrientedItemFacade thisSellerItemFacade = new SellerOrientedItemFacade();
			thisSellerItemFacade.setSellerItem(0, Integer.parseInt(sellerId), sellerName, itemName, 
					Float.parseFloat(price), Integer.parseInt(stock), description);
			
			// invoke behavior conductor to add item, return true if success
			return bc.addItem(thisSellerItemFacade.getSellerItemData());
		}catch(Exception error) {
			return false;
		}
		
	}
}
