package controller;

import java.sql.Date;

import dto.User;
import facade.UserFacade;

public class RegisterController extends Controller{
	// do register
	public String register(String username, String password, String phoneNumber, String userType) {
		UserFacade newUserFacade = new UserFacade();
		newUserFacade.setUser(username, password, phoneNumber, userType, new Date(new java.util.Date().getTime()));
		if(bc.isUserExisted(newUserFacade.getUserData())) {
			return "exist";
		}
		else if(!bc.register(newUserFacade.getUserData())) {
			return "fail";
		}
		return "success";
	}
}
