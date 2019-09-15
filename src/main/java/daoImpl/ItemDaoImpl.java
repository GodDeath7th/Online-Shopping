package daoImpl;

import dao.ItemDao;
import entity.Items;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemDaoImpl implements ItemDao {

    @Override
    public void addItem(Items items) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "insert into items(id,item_id,item_name,item_category,price,stock,description)values(?,?,?,?,?,?,?);";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, items.getId());
            preparedStatement.setString(2, items.getItemId());
            preparedStatement.setString(3, items.getName());
            preparedStatement.setString(4, items.getCategoryId());
            preparedStatement.setFloat(5, items.getPrice());
            preparedStatement.setInt(6,items.getStock());
            preparedStatement.setString(7,items.getDescription());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(preparedStatement, connection);
        }
    }
}
