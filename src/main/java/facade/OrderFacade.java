package facade;

import dto.Address;
import dto.Order;

public class OrderFacade {
	public Order order = new Order();
	public void setOrder(int userId, int itemId, int number, float price, Address addr) {
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
