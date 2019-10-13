package facade;

import dto.BuyerOrientedItem;

public class BuyerOrientedItemFacade {
	private BuyerOrientedItem item = new BuyerOrientedItem();
	public void setBuyerItem(String itemName, float price, int number) {

		item.setName(itemName);
		item.setPrice(price);
		item.setNumber(number);
		
	}
	
	public BuyerOrientedItem getBuyerItemData() {
		return item;
	}
}
