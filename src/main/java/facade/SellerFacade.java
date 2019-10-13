package facade;

import dto.Seller;

public class SellerFacade {
	private Seller seller;
	
	private void setSeller(float income) {
		if(seller == null) {
			seller = new Seller();
		}
		seller.setIncome(income);
	}
	
	public Seller getSellerData() {
		return seller;
	}
}
