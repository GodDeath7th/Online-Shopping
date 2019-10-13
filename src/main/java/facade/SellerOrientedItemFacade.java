package facade;

import dto.SellerOrientedItem;

public class SellerOrientedItemFacade {
	private SellerOrientedItem sellerItem;
	public void setSellerItem(int id, int sellerId, String sellerName, String itemName, float price, int stock, String description) {
		if(sellerItem == null) {
			sellerItem = new SellerOrientedItem();
		}
		sellerItem.setId(id);
		sellerItem.setSellerId(sellerId);
		sellerItem.setName(itemName);
		sellerItem.setSellerName(sellerName);
		sellerItem.setPrice(price);
		sellerItem.setStock(stock);
		sellerItem.setDescription(description);
	}
	
	public SellerOrientedItem getSellerItemData() {
		return sellerItem;
	}
}	
