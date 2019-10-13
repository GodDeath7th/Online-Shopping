package controller;

import facade.CartFacade;

public class AddToCartController extends Controller{
	public boolean AddToCart(String userId, String itemId, String itemName, String price, String number) {
		try {
			// generate cart facade
			CartFacade cartFacade= new CartFacade();
			cartFacade.setCart(Integer.parseInt(userId), Integer.parseInt(itemId), itemName, Float.parseFloat(price), Integer.parseInt(number));
			
			// add one item to cart by behavior conductor, return true if success
			return bc.addToCart(cartFacade.getCartData());
		}catch(Exception error) {
			return false;
		}
	}
}