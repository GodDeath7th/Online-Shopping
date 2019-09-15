package dao;

import entity.User;

public interface UserDao {
     void addUser(User user);
     User getUser(String name, String password);
     void updateAvatar(String id, String userImage);
     int getNumByName(String name);



}
