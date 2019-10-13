package facade;

import dto.Buyer;

public class BuyerFacade {
	private Buyer buyer = new Buyer();
	
	private void setBuyer(float balance) {
		buyer.setBalnce(balance);
	}
	
	public Buyer getBuyerData() {
		return buyer;
	}
}
