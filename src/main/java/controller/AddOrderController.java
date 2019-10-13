package controller;

import java.sql.Date;
import java.time.LocalDate;

import dto.Order;

public class AddOrderController extends Controller{
	public boolean addOrder(String buyerId, String sellerId, String itemId, String itemName, 
			String purchaseNumber, String priceForEach) {
		try {
			Order thisNewOrder = new Order();
			thisNewOrder.setBuyerId(Integer.parseInt(buyerId));
			thisNewOrder.setSellerId(Integer.parseInt(sellerId));
			thisNewOrder.setItemId(Integer.parseInt(itemId));
			thisNewOrder.setItemName(itemName);
			thisNewOrder.setPurchaseNumber(Integer.parseInt(purchaseNumber));
			thisNewOrder.setPriceForEach(Float.parseFloat(priceForEach));
			thisNewOrder.setTotalPrice(thisNewOrder.getPriceForEach()*thisNewOrder.getPurchaseNumber());
			thisNewOrder.setDate(new Date(new java.util.Date().getTime()));
			
			return bc.addOrder(thisNewOrder);
		}catch(Exception error) {
			return false;
		}
	}
}
