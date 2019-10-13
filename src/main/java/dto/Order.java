package dto;

import java.sql.Date;

public class Order {
	private int id;
	private int buyerId;
	private int sellerId;
	private int itemId;
	private String itemName;
	private int purchaseNumber;
	private float priceForEach;
	private float totalPrice;
	private Date date;
	private Address address;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBuyerId(){
		return buyerId;
	}
	
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	
	public int getSellerId() {
		return sellerId;
	}
	
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
	public int getItemId() {
		return itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public int getPurchaseNumber() {
		return purchaseNumber;
	}
	
	public void setPurchaseNumber(int purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	
	public float getPriceForEach() {
		return priceForEach;
	}
	
	public void setPriceForEach(float priceForEach) {
		this.priceForEach = priceForEach;
	}
	
	public float getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
}
