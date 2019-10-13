package controller;

import dto.Cart;

public class RemoveFromCartController extends Controller{
	// remove a item from cart for a user by giving cart id
	public boolean removeFromCart(String cartId) {
		Cart thisCart = new Cart();
		thisCart.setId(Integer.parseInt(cartId));
		return bc.removeFromCart(thisCart);
	}
}