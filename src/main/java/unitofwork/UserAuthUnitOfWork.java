package unitofwork;

import java.util.ArrayList;

import datasource.UserAuthMapper;
import dto.User;
import dto.UserAuthentication;

public class UserAuthUnitOfWork {
	private ArrayList<UserAuthentication> newUserAuths;
	private ArrayList<UserAuthentication> loggedUserAuths;
	private UserAuthMapper userAuthMapper;
	
	public UserAuthUnitOfWork() {
		userAuthMapper = new UserAuthMapper();
	}
	
	public boolean addUserAuth(UserAuthentication userAuth, boolean instantCommit) {
		if(newUserAuths == null) {
			newUserAuths = new ArrayList<>();
		}
		newUserAuths.add(userAuth);
		
		if(instantCommit) {
			return doCommit()[0];
		}
		return true;
	}
	
	public UserAuthentication getUserAuth(String phoneNumber, String password, String userType) {
		UserAuthentication thisUserAuth = userAuthMapper.getUserAuthByAuthUnits(phoneNumber, password, userType);
		return thisUserAuth;
	}
	
	// remove log out user
	public boolean removeUserAuthFromCleanSetByUserId(int userId) {
		if(loggedUserAuths == null) {
    		loggedUserAuths = new ArrayList<>();
    	}
		
		for(UserAuthentication loggedUserAuth: loggedUserAuths) {
			if(loggedUserAuth.getUserId() == userId) {
				loggedUserAuths.remove(loggedUserAuth);
				break;
			}
		}		
		return true;
	}
	
	public UserAuthentication login(String phoneNumber, String password, String userType) {
		UserAuthentication thisUserAuth = userAuthMapper.getUserAuthByAuthUnits(phoneNumber, password, userType);
		if(thisUserAuth != null) {
			// if no user logged 
			if(loggedUserAuths == null) {
				// add this user as logged 
				loggedUserAuths = new ArrayList<>();
				loggedUserAuths.add(thisUserAuth);
			}
			else {
				// if some users already logged
				for(UserAuthentication loggedUserAuth: loggedUserAuths) {
					// if this user is already logged, set user id to -1 so front end can know it is double-logging
					if(loggedUserAuth.getUserId() == thisUserAuth.getUserId()) {
						thisUserAuth.setUserId(-1);
					}
				}
			}
		}
		return thisUserAuth;
	}
	
	public boolean logout(int userId) {
		return this.removeUserAuthFromCleanSetByUserId(userId);
	}
	
    public boolean isUserLogged(String phoneNumber, String userType) {
    	if(loggedUserAuths == null) {
    		loggedUserAuths = new ArrayList<>();
    	}
    	
    	for(UserAuthentication loggedUserAuth: loggedUserAuths) {
    		if(loggedUserAuth.getPhoneNumber().equals(phoneNumber) && loggedUserAuth.getUserType().equals(userType)){
    			return true;
    		}
    	}
    	return false;
    }
    
	public boolean[] doCommit() {
		boolean isNewSuccess = true;
		if(newUserAuths != null) {
			if(newUserAuths.size() > 0) {
				if(userAuthMapper.addUserAuth(newUserAuths)) {
					newUserAuths.clear();
				}
				else {
					isNewSuccess = false;
				}
			}
		}
		
		return new boolean[] {isNewSuccess};
	}
}
