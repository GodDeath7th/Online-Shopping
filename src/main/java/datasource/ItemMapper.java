package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.SellerOrientedItem;

public class ItemMapper extends Mapper{
    public boolean insert(ArrayList<SellerOrientedItem> items) {
        Connection connection = this.getConneciton();
        try {
        	for(SellerOrientedItem item: items) {
        		String sql = "insert into item (seller_id, item_name, price,stock,description, seller_name) values (?,?,?,?,?,?)";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, item.getSellerId());
        		ps.setString(2, item.getName());
        		ps.setFloat(3, item.getPrice());
        		ps.setInt(4,item.getStock());
        		ps.setString(5,item.getDescription());
         		ps.setString(6, item.getSellerName());
        		
        		if(ps.executeUpdate() == 0) {
        			this.closeConnection(connection);
        			return false;
        		}
        	}
        	
        	this.closeConnection(connection);
        	return true;

        } catch (SQLException error) {
            this.closeConnection(connection);
            return false;
        } 
    }
    

    public boolean update(ArrayList<SellerOrientedItem> items) {
    	Connection connection = this.getConneciton();
        try {
        	for(SellerOrientedItem item: items) {
        		String sql = "update item set item_name = ?,price = ?,"
        				+ "stock = ?,description = ? where id = ?";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setString(1, item.getName());
        		ps.setFloat(2, item.getPrice());
        		ps.setInt(3,item.getStock());
        		ps.setString(4,item.getDescription());
        		ps.setInt(5, item.getId());
        		
        		if(ps.executeUpdate() == 0) {
        			this.closeConnection(connection);
        			return false;
        		}
        	}
        	
        	this.closeConnection(connection);
        	return true;

        } catch (SQLException error) {
            this.closeConnection(connection);
            return false;
        } 
    }
    
    public boolean delete(ArrayList<SellerOrientedItem> items) {
    	Connection connection = this.getConneciton();
        try {
        	for(SellerOrientedItem item: items) {
        		String sql = "delete from item where id = ?";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, item.getId());
        		
        		if(ps.executeUpdate() == 0) {
        			this.closeConnection(connection);
        			return false;
        		}
        	}
        	
        	this.closeConnection(connection);
        	return true;

        } catch (SQLException error) {
            this.closeConnection(connection);
            return false;
        } 
    }
    public ArrayList<SellerOrientedItem> getItemsByRange(String range, String[] parameters){
    	Connection connection = this.getConneciton();
    	ArrayList<SellerOrientedItem> thisRangeItems = null;
    	try {
    		PreparedStatement ps = null;
    		String sql = null;
    		// first range: item of a seller
    		if(range.equals("SELLER_ID")) {
    			sql = "select * from item where seller_id = ?";
        		ps = (PreparedStatement) connection.prepareStatement(sql);
    			ps.setInt(1, Integer.parseInt(parameters[0]));
    		}
    		// second range : all item
    		else if(range.equals("ALL")) {
    			sql = "select * from item";
    			ps = (PreparedStatement) connection.prepareStatement(sql);
    		}
    		// third range: item whose name includes keyword
    		else if(range.equals("KEYWORD")) {
    			sql = "select * from item where item_name like '%"+parameters[0]+"%' "
    					+ "or description like '%"+parameters[0]+"%'";
    			ps = (PreparedStatement) connection.prepareStatement(sql);
    		}
    		// forth range: an specific item with given id
    		else if(range.equals("ITEM_ID")) {
    			sql = "select * from item where id = ?";
    			ps = (PreparedStatement) connection.prepareStatement(sql);
    			ps.setInt(1, Integer.parseInt(parameters[0]));
    		}
    		else {
    			this.closeConnection(connection);
    			return null;
    		}
    		
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			if(thisRangeItems == null) {
    				thisRangeItems = new ArrayList<>();
    			}
    			
    			SellerOrientedItem thisRangeEachItem = new SellerOrientedItem();
    			thisRangeEachItem.setId(rs.getInt("id"));
    			thisRangeEachItem.setSellerId(rs.getInt("seller_id"));
    			thisRangeEachItem.setSellerName(rs.getString("seller_name"));
    			thisRangeEachItem.setName(rs.getString("item_name"));
    			thisRangeEachItem.setPrice(rs.getFloat("price"));
    			thisRangeEachItem.setStock(rs.getInt("stock"));
    			thisRangeEachItem.setDescription(rs.getString("description"));
    			
    			thisRangeItems.add(thisRangeEachItem);
    		}
    		this.closeConnection(connection);
    		return thisRangeItems;
    	}
    	catch (SQLException error) {
    		this.closeConnection(connection);
            return thisRangeItems;
        }
    }
    
    // set stock of an item by add stock to it, the number of stock could be negative
    public boolean changeStock(int itemId, int stock) {
    	Connection connection = this.getConneciton();
        try {
        	String sql = "update item set stock = stock + "+stock+" where id = ?";
        	PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        	ps.setInt(1, itemId);
        		
        	if(ps.executeUpdate() == 0) {
        		this.closeConnection(connection);
        		return false;
        	}
        	
        	this.closeConnection(connection);
        	return true;

        } catch (SQLException error) {
            this.closeConnection(connection);
            return false;
        } 
    }
}
