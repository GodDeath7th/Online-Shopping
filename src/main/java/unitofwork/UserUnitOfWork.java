package unitofwork;


import java.util.ArrayList;

import datasource.UserMapper;
import dto.User;
import dto.UserAuthentication;

public class UserUnitOfWork {
	// user cannot be deleted, so no deleteUsers
	private ArrayList<User> newUsers;
	private ArrayList<User> dirtyUsers;
	private UserMapper userMapper;
	
	public UserUnitOfWork() {
		userMapper = new UserMapper();
	}
    
    public boolean addUser(User user, boolean instantCommit) {
    	// lazy load, initialize newUsers when needed
    	if(newUsers == null) {
    		newUsers = new ArrayList<>();
    	}
    	// add this user in new list
    	newUsers.add(user);
    	
    	// if need this change be committed to database instantly, set this boolean true
    	if(instantCommit) {
    		return this.doCommit()[0];
    	}
    	return true;
    }
    
    public boolean updateUser(User user, boolean instantCommit) {
    	if(dirtyUsers == null) {
    		dirtyUsers = new ArrayList<>();
    	}
    	
    	// update a existing user
    	dirtyUsers.add(user);
    	
    	// if need this change be committed to database instantly, set this boolean true
    	if(instantCommit) {
    		return this.doCommit()[1];
    	}    	
    	return true;
    }
    
    // get a user by user id
    public User getUserById(int id) {
    	User thisUser = userMapper.getUserById(id);
    	return thisUser;
    }
       
    // check if a user already registered
    public boolean isUserExisted(User user) {
    	return userMapper.isUserExisted(user) || userMapper.isNameUsed(user);
    }
    
    // get a user by giving its phone number and user type
    public User getUserByPair(String phoneNumber, String userType) {
    	return userMapper.getUserByPair(phoneNumber, userType);
    }
    // commit change to database
    public boolean[] doCommit() {
    	boolean isNewSuccess = true;
    	boolean isUpdateSuccess = true;
    	if(newUsers != null) {
    		if(newUsers.size() > 0) {
    			if(userMapper.insert(newUsers)){
    				newUsers.clear();
    			}
    			else {
    				isNewSuccess = false;
    			}
    		}
    	}
    	
    	if(dirtyUsers != null) {
    		if(dirtyUsers.size() > 0) {
    			if(userMapper.update(dirtyUsers)) {
    				dirtyUsers.clear();
    			}
    			else {
    				isUpdateSuccess = false;
    			}
    		}
    	}
    	
    	return new boolean[] {isNewSuccess, isUpdateSuccess};
    }
    	    
}
