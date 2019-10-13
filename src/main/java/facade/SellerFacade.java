package facade;

import dto.Seller;

public class SellerFacade {
	private Seller seller = new Seller();
	
	private void setSeller(float income) {
		seller.setIncome(income);
	}
	
	public Seller getSellerData() {
		return seller;
	}
}
