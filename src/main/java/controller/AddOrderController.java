package controller;

import java.sql.Date;
import java.time.LocalDate;

import dto.Order;

public class AddOrderController extends Controller{
	// generate order object to add order for a buyer
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
			
			// add order by behavior conductor, return true if success
			return bc.addOrder(thisNewOrder);
		}catch(Exception error) {
			return false;
		}
	}
}
