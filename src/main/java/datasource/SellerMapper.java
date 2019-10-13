package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Seller;

public class SellerMapper extends Mapper{
	public boolean insert(ArrayList<Seller> sellers) {
		Connection connection = this.getConneciton();
		try {
			for(Seller seller: sellers) {
				String sql = "insert into seller (user_id, income) values (?, ?)";
				PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
				ps.setInt(1, seller.getId());
				ps.setFloat(2, seller.getIncome());
				
				if(ps.executeUpdate() == 0) {
					this.closeConnection(connection);
					return false;
				}
			}
			
			this.closeConnection(connection);
			return true;
		}catch(SQLException error) {
			this.closeConnection(connection);
			return false;
		}
	}
	
	public boolean update(ArrayList<Seller> sellers) {
		Connection connection = this.getConneciton();
		try {
			for(Seller seller: sellers) {
				String sql = "update seller set income = ? where user_id = ?";
				PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
				ps.setFloat(1, seller.getIncome());
				ps.setInt(2, seller.getId());
				
				if(ps.executeUpdate() == 0) {
					this.closeConnection(connection);
					return false;
				}
			}
			
			this.closeConnection(connection);
			return true;
		}catch(SQLException error) {
			this.closeConnection(connection);
			return false;
		}
	}
	
	public Seller getSellerById(int id) {
		Connection connection = this.getConneciton();
    	Seller thisSeller = null;
    	try {
    		String sql = "select * from seller where user_id = ?";
    		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
    		ps.setInt(1, id);
    		
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			thisSeller = new Seller();
    			thisSeller.setId(rs.getInt("user_id"));
    			thisSeller.setIncome(rs.getFloat("income"));
    		}
    		
			this.closeConnection(connection);
			return thisSeller;

    	}catch(SQLException error) {
    		this.closeConnection(connection);
    		return thisSeller;
    	}
	}
	
	// change income of a seller, the numberof money will not be negative
	public boolean changeIncome(int sellerId, float money) {
		Connection connection = this.getConneciton();
		try {
			String sql = "update seller set income = income + "+money+" where user_id = ?";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
    		ps.setInt(1, sellerId);
    		
    		if(ps.executeUpdate() == 0) {
    			this.closeConnection(connection);
    			return false;
    		}
    		
    		this.closeConnection(connection);
    		return true;
		}catch(SQLException error) {
			this.closeConnection(connection);
			return false;
		}
	}
}
