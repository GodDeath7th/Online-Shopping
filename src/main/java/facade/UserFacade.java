package facade;

import java.sql.Date;

import dto.User;

public class UserFacade {
	private User user;
	public void setUser(String username, String password, String phoneNumber, String userType, Date date) {
		if(user == null) {
			user = new User();
		}
		user.setUsername(username);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setUserType(userType);
		user.setDate(date);
	}
	
	public User getUserData(){
		return user;
	}
}
