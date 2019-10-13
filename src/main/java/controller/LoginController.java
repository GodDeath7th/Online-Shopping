package controller;

import dto.UserAuthentication;

public class LoginController extends Controller{
	// do login by invoking behavior conductor
	public UserAuthentication login(String phoneNumber, String password, String userType) {
		if(bc.isUserLogged(phoneNumber, userType)) {
			UserAuthentication doubleLoggedUserAuth = new UserAuthentication();
			doubleLoggedUserAuth.setId(-1);
			return doubleLoggedUserAuth;
		}
		return bc.login(phoneNumber, password, userType);
	}
}
