package daoImpl;

import dao.UserDao;
import entity.User;
import util.JdbcUtils;

import java.net.URISyntaxException;
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
            String sql = "insert into member(name,password,phone_number,date_create)values(?,?,?,?);";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setString(4, user.getDateCreate());
            preparedStatement.executeUpdate();

        } catch (URISyntaxException |SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
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
        } catch (URISyntaxException |SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
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
            String sql = "select * from member WHERE name = ? and password = ?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                u = new User();
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                u.setPassword(resultSet.getString("password"));
                return u;
            }
        } catch (URISyntaxException |SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    @Override
    public void updateAvatar(int id, String userImage) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "UPDATE member set avatar =? where id = ?;";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, userImage);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (URISyntaxException |SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
    }


}
