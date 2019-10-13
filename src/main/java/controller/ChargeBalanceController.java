package controller;

public class ChargeBalanceController extends Controller{
	public boolean chargeBalance(String buyerId, String money) {
		try {
			// charge balance of a buyer, return true if success
			return bc.changeBalance(Integer.parseInt(buyerId), Float.parseFloat(money));
		}catch(Exception error) {
			return false;
		}
	}
}
