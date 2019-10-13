package dto;

/* this class is for standing each item that will appear in cart for a user, if this item is placed into order,
 * its attribute id, name, price and number will be saved into "order" table in database, if not, this attributes
 * will show in "cart" table in database, while it does not has a table named "item" for him(this table is for SellerOrientedItem)
 */
public class BuyerOrientedItem {
	private int itemId;
	private String name;
	private float price;
	private int number;
	
	public int getItemId() {
		return itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
}
