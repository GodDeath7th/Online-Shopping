package daoImpl;

import dao.ItemDao;
import entity.Item;
import entity.User;
import util.JdbcUtils;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDao {

    @SuppressWarnings("finally")
    public boolean addItem(ArrayList<Item> items) {
        Connection connection = null;
        try {
        	connection = JdbcUtils.getconn();
        	for(Item item: items) {
        		String sql = "INSERT INTO item (user_id,name,category,price,stock,description) VALUES (?,?,?,?,?,?);";
        		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        		preparedStatement.setInt(1, item.getUserId());
        		preparedStatement.setString(2, item.getName());
        		preparedStatement.setString(3, item.getCategory());
        		preparedStatement.setFloat(4, item.getPrice());
        		preparedStatement.setInt(5,item.getStock());
        		preparedStatement.setString(6,item.getDescription());
        		preparedStatement.executeUpdate();
        	}

        } catch (URISyntaxException |SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUtils.close(connection);
            return true;
        }
    }
    
    @SuppressWarnings("finally")
    public boolean updateItem(ArrayList<Item> items) {
    	Connection connection = null;
    	try {
    		connection = JdbcUtils.getconn();
    		for(Item item: items) {
    			String sql = "UPDATE item SET name = ?, category = ?,"+
    						 " price = ?, stock = ?, description = ? WHERE id = ?";
        		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        		preparedStatement.setString(1, item.getName());
        		preparedStatement.setString(2, item.getCategory());
        		preparedStatement.setFloat(3, item.getPrice());
        		preparedStatement.setInt(4,item.getStock());
        		preparedStatement.setString(5,item.getDescription());
        		preparedStatement.setInt(6, item.getId());
        		preparedStatement.executeUpdate();
    		}
    	} catch (URISyntaxException |SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUtils.close(connection);
            return true;
        }
    }
    
    @SuppressWarnings("finally")
	public boolean deleteItem(ArrayList<Item> items) {
    	Connection connection = null;
    	try {
    		connection = JdbcUtils.getconn();
    		for(Item item: items) {
    			String sql = "DELETE  FROM item WHERE id = ?";
        		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        		preparedStatement.setInt(1, item.getId());
        		preparedStatement.executeUpdate();
    		}
    	} catch (URISyntaxException |SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUtils.close(connection);
            return true;
        }
    }
    
    @SuppressWarnings("finally")
	public ArrayList<Item> getItem(int userId){
    	Connection connection = null;
    	ArrayList<Item> items = new ArrayList<>();
    	
    	try {
    		connection = JdbcUtils.getconn();
    		String sql = "select * from item where user_id = ?";
    		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
    		preparedStatement.setInt(1, userId);
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		while(rs.next()) {
    			Item item = new Item();
    			item.setId(rs.getInt("id"));
    			item.setUserId(rs.getInt("user_id"));
    			item.setName(rs.getString("name"));
    			item.setCategory(rs.getString("category"));
    			item.setPrice(rs.getFloat("price"));
    			item.setStock(rs.getInt("stock"));
    			item.setDescription(rs.getString("description"));
    			
    			items.add(item);
    		}
    	}catch (URISyntaxException |SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtils.close(connection);
            return items;
        }
    }
}
