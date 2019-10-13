package controller;

public class LogoutController extends Controller{
	// do log out by invoking behavior conductor
	public boolean Logout(String userId) {
		return bc.logout(Integer.parseInt(userId));
	}
}
