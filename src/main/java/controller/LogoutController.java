package controller;

public class LogoutController extends Controller{
	public boolean Logout(String userId) {
		return bc.logout(Integer.parseInt(userId));
	}
}
