package controller;

import dto.Order;

public class DeleteOrderController extends Controller{
	public boolean deleteOrder(String orderId) {
		// delete an order by giving its id in database
		Order thisOrder = new Order();
		thisOrder.setId(Integer.parseInt(orderId));
		return bc.deleteOrder(thisOrder);
	}
}
