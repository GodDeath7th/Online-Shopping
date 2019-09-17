package controller;

import entity.User;
import serviceImp.UserServiceImpl;


public class UserLogin {

    private UserServiceImpl userService = new UserServiceImpl();

    public User login(String username, String password) {
    	return userService.login(username, password);
    }

}
