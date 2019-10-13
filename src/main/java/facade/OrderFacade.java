package facade;

import dto.Address;
import dto.Order;

public class OrderFacade {
	public Order order;
	public void setOrder(int userId, int itemId, int number, float price, Address addr) {
		if(order == null) {
			order = new Order();
		}
		order.setBuyerId(userId);
		order.setItemId(itemId);
		order.setPurchaseNumber(number);
		order.setPriceForEach(price);
		order.setAddress(addr);
	}
	
	public Order getOrderData() {
		return order;
	}
}
