package entity;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Item> wishList;
	public Cart() {
		wishList = new ArrayList<>();
	}
	
	public Cart(ArrayList<Item> wishList) {
		this.wishList = wishList;
	}
	
	public ArrayList<Item> getWishList(){
		return wishList;
	}
	
	public void SetWishList(ArrayList<Item> wishList) {
		this.wishList = wishList;
	}
}