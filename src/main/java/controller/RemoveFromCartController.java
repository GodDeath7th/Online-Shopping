package controller;

import dto.Cart;

public class RemoveFromCartController extends Controller{
	public boolean removeFromCart(String cartId) {
		Cart thisCart = new Cart();
		thisCart.setId(Integer.parseInt(cartId));
		return bc.removeFromCart(thisCart);
	}
}