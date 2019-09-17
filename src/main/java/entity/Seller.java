package entity;

public class Seller extends User{
	private float income;
	
	/*public Seller(String id, String name, String password, String phoneNumber, String userImage, String dateCreate, String Avatar, float income) {
		super(id, name, password, phoneNumber, userImage, dateCreate, Avatar);
		this.income = income;
	}*/
	
	public float getIncome() {
		return income;
	}
	
	public void setIncome(float income) {
		this.income = income;
	}
}
	
	