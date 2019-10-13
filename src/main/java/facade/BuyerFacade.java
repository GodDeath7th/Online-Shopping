package facade;

import dto.Buyer;

public class BuyerFacade {
	private Buyer buyer;
	
	private void setBuyer(float balance) {
		if(buyer == null) {
			buyer = new Buyer();
		}
		buyer.setBalnce(balance);
	}
	
	public Buyer getBuyerData() {
		return buyer;
	}
}
