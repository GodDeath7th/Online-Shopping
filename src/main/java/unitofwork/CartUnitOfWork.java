package unitofwork;

import java.util.ArrayList;

import datasource.CartMapper;
import dto.Buyer;
import dto.Cart;

public class CartUnitOfWork {
	private ArrayList<Cart> newCarts;
	private ArrayList<Cart> dirtyCarts;
	private ArrayList<Cart> deleteCarts;
	private CartMapper cartMapper;
	
	public CartUnitOfWork() {
		cartMapper = new CartMapper();
	}
	
	public boolean addCart(Cart cart, boolean instantCommit) {
		if(newCarts == null) {
			newCarts = new ArrayList<>();
		}
		newCarts.add(cart);
		
		if(instantCommit) {
			return doCommit()[0];
		}
		return true;
	}
	
	public boolean updateCart(Cart cart, boolean instantCommit) {
		if(dirtyCarts == null) {
			dirtyCarts = new ArrayList<>();
		}
		dirtyCarts.add(cart);

		if(instantCommit) {
			return doCommit()[1];
		}
		return true;
	}
	
	public boolean deleteCart(Cart cart, boolean instantCommit) {
		if(deleteCarts == null) {
			deleteCarts = new ArrayList<>();
		}
		deleteCarts.add(cart);
		
		if(instantCommit) {
			return doCommit()[2];
		}
		
		return true;
	}
	
	public ArrayList<Cart> getCartsByBuyerId(int buyerId){
		ArrayList<Cart> thisBuyerCarts = cartMapper.getCartByBuyerId(buyerId);
		return thisBuyerCarts;
	}
	
	public boolean[] doCommit() {
		boolean isNewSuccess = true;
		boolean isUpdateSuccess = true;
		boolean isDeleteSuccess = true;
		
		if(newCarts != null) {
			if(newCarts.size() > 0) {
				if(cartMapper.insert(newCarts)){
					newCarts.addAll(newCarts);
					newCarts.clear();
				}
				else {
					isNewSuccess = false;
				}
			}
		}
		if(dirtyCarts != null) {
			if(dirtyCarts.size() > 0) {
				if(cartMapper.update(dirtyCarts)) {
					dirtyCarts.clear();
				}
				else {
					isUpdateSuccess = true;
				}
			}
		}
		if(deleteCarts != null) {
			if(deleteCarts.size() > 0 ) {
				if(cartMapper.delete(deleteCarts)) {
					deleteCarts.clear();
				}
				else {
					isDeleteSuccess = false;
				}
			}
		}
		
		return new boolean[] {isNewSuccess, isUpdateSuccess, isDeleteSuccess};
	}
}
