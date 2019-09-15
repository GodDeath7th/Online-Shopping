package serviceImp;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import entity.User;
import service.UserService;
import util.Util;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void register(User user) {
        UserDaoImpl userDao = new UserDaoImpl();
        user.setId(Util.getId());
        user.setDateCreate(Util.getDate());
        user.setRole(1);
        userDao.addUser(user);
    }

    @Override
    public boolean isexist(String name) {
        int count = userDao.getNumByName(name);
        return count!=0;
    }

    @Override
    public User login(String name, String password) {
        return userDao.getUser(name,password);
    }


    @Override
    public void updateAvatar(String id, String name) {
        userDao.updateAvatar(id,name);
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}
