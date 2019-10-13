package dto;

import java.util.ArrayList;
// it is important to know cart here is not stands for whole cart while only an item in cart, 
// this is way a buyerorienteditem object is here to save information of this item
// Also, to stands for conceptual cart, it needs ArrayList<Cart>
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