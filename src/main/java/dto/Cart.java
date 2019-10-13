package dto;

import java.util.ArrayList;

public class Cart {
	private int id;
	private int userId;
	private BuyerOrientedItem buyerItem;
	
	public Cart() {
		buyerItem = new BuyerOrientedItem();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
		
	public BuyerOrientedItem getBuyerItem(){
		return buyerItem;
	}
	
	public void SetWishList(BuyerOrientedItem buyerItem) {
		this.buyerItem = buyerItem;
	}
}