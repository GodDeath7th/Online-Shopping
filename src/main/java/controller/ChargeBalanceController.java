package controller;

public class ChargeBalanceController extends Controller{
	public boolean chargeBalance(String buyerId, String money) {
		try {
			return bc.changeBalance(Integer.parseInt(buyerId), Float.parseFloat(money));
		}catch(Exception error) {
			return false;
		}
	}
}
