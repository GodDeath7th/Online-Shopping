package facade;

import dto.UserAuthentication;

public class UserAuthFacade {
	private UserAuthentication userAuth;
	
	private void setUserAuth(String phoneNumber, String password, String userType) {
		if(userAuth == null) {
			userAuth = new UserAuthentication();
		}
		userAuth.setPhoneNumber(phoneNumber);
		userAuth.setPassword(password);
		userAuth.setUserType(userType);
	}
	
	public UserAuthentication getUserAuthData() {
		return userAuth;
	}
	
}
