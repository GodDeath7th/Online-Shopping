package controller;

import java.sql.Date;
import java.util.ArrayList;

import dto.Address;
import dto.Cart;
import dto.Order;

public class PurchaseController extends Controller{
	// conduct purchase for a user by giving its userId
	public String purchase(String userId) {
		return bc.purchase(Integer.parseInt(userId));
	}
}
