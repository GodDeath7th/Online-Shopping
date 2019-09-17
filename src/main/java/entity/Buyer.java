package entity;

public class Buyer extends User{
	private float balance;
	private Address address;
	private Cart cart;
	
	/*public Buyer(String id, String name, String password, String phoneNumber, String userImage, String dateCreate, String Avatar, float blance, Cart cart) {
		super(id, name, password, phoneNumber, userImage, dateCreate, Avatar);
		this.balance = blance;
		this.cart = cart;
	}*/
	
	public float getBlance() {
		return balance;
	}
	
	public void setBalnce(float balance) {
		this.balance = balance;
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
}	

	
	