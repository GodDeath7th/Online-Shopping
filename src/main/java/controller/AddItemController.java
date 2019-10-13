package controller;

import facade.SellerOrientedItemFacade;

public class AddItemController extends Controller{
	public boolean addItem(String sellerId, String sellerName, String itemName, String price, String stock, String description) {
		try {
			SellerOrientedItemFacade thisSellerItemFacade = new SellerOrientedItemFacade();
			thisSellerItemFacade.setSellerItem(0, Integer.parseInt(sellerId), sellerName, itemName, 
					Float.parseFloat(price), Integer.parseInt(stock), description);
			
			return bc.addItem(thisSellerItemFacade.getSellerItemData());
		}catch(Exception error) {
			return false;
		}
		
	}
}
