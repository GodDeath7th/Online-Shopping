package datasource;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Cart;

public class CartMapper extends Mapper{
	public boolean insert(ArrayList<Cart> carts) {
        Connection connection = this.getConneciton();
        try {
        	for(Cart cart: carts) {
        		String sql = "insert into cart (user_id, item_id, item_name, number, price) VALUES (?,?,?,?,?)";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, cart.getUserId());
        		ps.setInt(2, cart.getBuyerItem().getItemId());
        		ps.setString(3, cart.getBuyerItem().getName());
        		ps.setInt(4, cart.getBuyerItem().getNumber());
        		ps.setFloat(5, cart.getBuyerItem().getPrice());
        		
        		if(ps.executeUpdate() == 0) {
        			this.closeConnection(connection);
        			return false;
        		}
        	}

        } catch (SQLException error) {
            this.closeConnection(connection);
            return false;
        } 
        this.closeConnection(connection);
        return true;
    }
    
	public boolean update(ArrayList<Cart> carts) {
        Connection connection = this.getConneciton();
        try {
        	for(Cart cart: carts) {
        		String sql = "update item set user_id = ?, item_id = ?, item_name = ?, number = ?, "
        				+ "price = £¿ where id = ?";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, cart.getUserId());
        		ps.setInt(2, cart.getBuyerItem().getItemId());
        		ps.setString(3, cart.getBuyerItem().getName());
        		ps.setInt(4, cart.getBuyerItem().getNumber());
        		ps.setFloat(5, cart.getBuyerItem().getPrice());
        		ps.setInt(6, cart.getId());
        		
        		if(ps.executeUpdate() == 0) {
        			this.closeConnection(connection);
        			return false;
        		}
        	}

        } catch (SQLException error) {
            this.closeConnection(connection);
            return false;
        } 
        this.closeConnection(connection);
        return true;
    }
    
	public boolean delete(ArrayList<Cart> carts) {
        Connection connection = this.getConneciton();
        try {
        	for(Cart cart: carts) {
        		String sql = "delete from cart where id = ?";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, cart.getId());
        		
        		if(ps.executeUpdate() == 0) {
        			this.closeConnection(connection);
        			return false;
        		}
        	}

        } catch (SQLException error) {
            this.closeConnection(connection);
            return false;
        } 
        this.closeConnection(connection);
        return true;
    }
    
    public ArrayList<Cart> getCartByBuyerId(int userId) {
        Connection connection = this.getConneciton();
        ArrayList<Cart> thisUserCarts = null;
        
        try {
        	String sql = "select * from cart where user_id = ?";
        	PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        	ps.setInt(1, userId);
        	
        	ResultSet rs = ps.executeQuery();
        	while(rs.next()) {
        		if(thisUserCarts == null) {
        			thisUserCarts = new ArrayList<>();
        		}
        		
        		Cart thisUserEachCart = new Cart();
        		thisUserEachCart.setId(rs.getInt("id"));
        		thisUserEachCart.getBuyerItem().setItemId(rs.getInt("item_id"));
        		thisUserEachCart.getBuyerItem().setName(rs.getString("item_name"));
        		thisUserEachCart.getBuyerItem().setNumber(rs.getInt("number"));
        		thisUserEachCart.getBuyerItem().setPrice(rs.getFloat("price"));
        		
        		thisUserCarts.add(thisUserEachCart);
        	}
        	
        } catch (SQLException error) {
            this.closeConnection(connection);
            return thisUserCarts;
        } 
        this.closeConnection(connection);
        return thisUserCarts;
    }
}