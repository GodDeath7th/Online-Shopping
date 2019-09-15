package daoImpl;

import dao.UserDao;
import entity.User;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {


    @Override
    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "insert into user(id,name,password,phoneNumber,dateCreate,role)values(?,?,?,?,?,?);";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getDateCreate());
            preparedStatement.setInt(6,user.getRole());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(preparedStatement, connection);
        }
    }

    @Override
    public int getNumByName(String name) {
        int i = 0 ;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "select COUNT(*) from user WHERE name = ?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                i = resultSet.getInt(1);
                System.out.println(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(preparedStatement, connection);
        }
        return i;
    }


    @Override
    public User getUser(String name, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        User u = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "select id,name,role from user WHERE name = ? and password = ?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                u = new User();
                u.setId(resultSet.getString(1));
                u.setName(resultSet.getString(2));
                u.setRole(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(preparedStatement, connection);
        }
        return u;
    }

    @Override
    public void updateAvatar(String id, String userImage) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "UPDATE User set avatar =? where id = ?;";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, userImage);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(preparedStatement, connection);
        }
    }


}
