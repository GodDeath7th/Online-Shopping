package controller;

import dto.User;

public class EditProfileController extends Controller{
	public boolean editProfile(String userId, String username) {
		User thisUser = new User();
		thisUser.setId(Integer.parseInt(userId));
		thisUser.setUsername(username);
		return bc.editProfile(thisUser);
	}
}