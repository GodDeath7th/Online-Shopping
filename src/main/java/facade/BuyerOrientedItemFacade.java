package facade;

import dto.BuyerOrientedItem;

public class BuyerOrientedItemFacade {
	private BuyerOrientedItem item;
	public void setBuyerItem(String itemName, float price, int number) {
		if(item == null) {
			item = new BuyerOrientedItem();
		}

		item.setName(itemName);
		item.setPrice(price);
		item.setNumber(number);
		
	}
	
	public BuyerOrientedItem getBuyerItemData() {
		return item;
	}
}
