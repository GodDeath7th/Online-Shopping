package entity;

public class User {
    private int id;
    private String name;
    private String password;
    private String phoneNumber;
    private String userImage;
    private String dateCreate;
    private String Avatar;
    
    public User() {}
    
    /*public User(String id, String name, String password, String phoneNumber, String userImage, String dateCreate, String Avatar) {
    	this.id = id;
    	this.name = name;
    	this.password = password;
    	this.phoneNumber = phoneNumber;
    	this.userImage = userImage;
    	this.dateCreate = dateCreate;
    	this.Avatar = Avatar;
    }*/
    
    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }
}