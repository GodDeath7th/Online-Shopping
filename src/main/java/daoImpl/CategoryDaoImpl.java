package daoImpl;

import dao.CategoryDao;
import entity.Categroy;
import util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public void addCategort(Categroy categroy) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "insert into item_category(id,name,numbers)values(?,?,?);";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, categroy.getId());
            preparedStatement.setString(2, categroy.getName());
            preparedStatement.setInt(3, categroy.getNumber());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(preparedStatement, connection);
        }
    }

    @Override
    public List<Categroy> getCategory() {
        List<Categroy> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "select * from item_category ";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Categroy categroy = new Categroy();
                categroy.setId(resultSet.getString("id"));
                categroy.setName(resultSet.getString("name"));
                categroy.setNumber(resultSet.getInt("number"));
                list.add(categroy);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateItemNum(String id, int number) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "UPDATE item set numbers = numbers + ? where id = ?;";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setInt(1, number);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(preparedStatement, connection);
        }
    }
}