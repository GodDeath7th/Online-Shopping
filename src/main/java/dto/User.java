package dto;

import java.sql.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String phoneNumber;
    private Date date;
    private String userType;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getUserType() {
    	return userType;
    }
    
    public void setUserType(String userType) {
    	this.userType = userType;
    }
}