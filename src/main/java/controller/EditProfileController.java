package controller;

import dto.User;

public class EditProfileController extends Controller{
	// change username of a user by behavior conductor by giving its id in database and new username
	public boolean editProfile(String userId, String username) {
		User thisUser = new User();
		thisUser.setId(Integer.parseInt(userId));
		thisUser.setUsername(username);
		return bc.editProfile(thisUser);
	}
}