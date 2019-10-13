package datasource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Address;
import dto.Order;

public class OrderMapper extends Mapper{
	public boolean insert(ArrayList<Order> orders) {
        Connection connection = this.getConneciton();
        try {
        	for(Order order: orders) {
        		String sql = "insert into shop_order (buyer_id, seller_id, item_id, item_name, purchase_number, price_for_each, total_price, date, address, state, country, zip) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, order.getBuyerId());
        		ps.setInt(2, order.getSellerId());
        		ps.setInt(3, order.getItemId());
        		ps.setString(4, order.getItemName());
        		ps.setInt(5, order.getPurchaseNumber());
        		ps.setFloat(6, order.getPriceForEach());
        		ps.setFloat(7, order.getPurchaseNumber()*order.getPriceForEach());
        		ps.setDate(8, order.getDate());
        		ps.setString(9, order.getAddress().getAddress());
        		ps.setString(10, order.getAddress().getState());
        		ps.setString(11, order.getAddress().getCountry());
        		ps.setString(12, order.getAddress().getZip());
        		
        		if(ps.executeUpdate() == 0) {
        			this.closeConnection(connection);
        			return false;
        		}
        	}

        } catch (SQLException error) {
        	System.out.println(error.getMessage());
        	System.out.println(error.getSQLState());
            this.closeConnection(connection);
            return false;
        } 
        this.closeConnection(connection);
        return true;
    }

	public boolean delete(ArrayList<Order> orders) {
        Connection connection = this.getConneciton();
        try {
        	for(Order order: orders) {
        		String sql = "delete from shop_order where id = ?";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, order.getId());
        		
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
    
    public ArrayList<Order> getOrderByUserId(int userId) {
        Connection connection = this.getConneciton();
        ArrayList<Order> thisUserOrders = null;
        try {
        	String sql = "select * from shop_order where buyer_id = ? or seller_id = ?";
        	PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        	ps.setInt(1, userId);
        	ps.setInt(2, userId);
        	
        	ResultSet rs = ps.executeQuery();
        	while(rs.next()) {
        		if(thisUserOrders == null) {
        			thisUserOrders = new ArrayList<>();
        		}
        		
        		Order thisUserEachOrder = new Order();
        		thisUserEachOrder.setId(rs.getInt("id"));
        		thisUserEachOrder.setBuyerId(rs.getInt("buyer_id"));
        		thisUserEachOrder.setSellerId(rs.getInt("seller_id"));
        		thisUserEachOrder.setItemId(rs.getInt("item_id"));
        		thisUserEachOrder.setItemName(rs.getString("item_name"));
        		thisUserEachOrder.setPurchaseNumber(rs.getInt("purchase_number"));
        		thisUserEachOrder.setPriceForEach(rs.getFloat("price_for_each"));
        		thisUserEachOrder.setTotalPrice(rs.getFloat("total_price"));
        		thisUserEachOrder.setDate(rs.getDate("date"));
        		
        		Address addr = new Address();
        		addr.setAddress(rs.getString("address"));
        		addr.setState(rs.getString("state"));
        		addr.setCountry(rs.getString("country"));
        		addr.setZip(rs.getString("zip"));
        		
        		thisUserEachOrder.setAddress(addr);
        		thisUserOrders.add(thisUserEachOrder);
        	}
        	
        } catch (SQLException error) {
            this.closeConnection(connection);
            return thisUserOrders;
        } 
        this.closeConnection(connection);
        return thisUserOrders;
    }
}
