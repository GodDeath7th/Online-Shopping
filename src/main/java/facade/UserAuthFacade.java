package facade;

import dto.UserAuthentication;

public class UserAuthFacade {
	private UserAuthentication userAuth = new UserAuthentication();
	
	private void setUserAuth(String phoneNumber, String password, String userType) {
		userAuth.setPhoneNumber(phoneNumber);
		userAuth.setPassword(password);
		userAuth.setUserType(userType);
	}
	
	public UserAuthentication getUserAuthData() {
		return userAuth;
	}
	
}
