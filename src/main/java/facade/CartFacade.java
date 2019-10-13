package facade;

import dto.BuyerOrientedItem;
import dto.Cart;

public class CartFacade {
	private Cart cart = new Cart();
	public void setCart(int userId, int itemId, String itemName, float price, int number) {
		BuyerOrientedItem thisItem = new BuyerOrientedItem();
		thisItem.setItemId(itemId);
		thisItem.setName(itemName);
		thisItem.setPrice(price);
		thisItem.setNumber(number);
		
		cart.setUserId(userId);
		cart.SetWishList(thisItem);
	}
	
	public Cart getCartData() {
		return cart;
	}
}
