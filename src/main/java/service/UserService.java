package service;

import entity.User;

public interface UserService {
    void register(User user);

    User login(String name, String password);

    boolean isexist(String name);

    void updateAvatar(int id,String name);


}
