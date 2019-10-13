package controller;

import dto.Order;

public class DeleteOrderController extends Controller{
	public boolean deleteOrder(String orderId) {
		Order thisOrder = new Order();
		thisOrder.setId(Integer.parseInt(orderId));
		return bc.deleteOrder(thisOrder);
	}
}
