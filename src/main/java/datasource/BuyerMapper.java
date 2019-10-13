package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Buyer;

public class BuyerMapper extends Mapper{
	public boolean insert(ArrayList<Buyer> buyers) {
		Connection connection = this.getConneciton();
		try {
			for(Buyer buyer: buyers) {
				String sql = "insert into buyer (user_id, balance) values (?, ?)";
				PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
				ps.setInt(1, buyer.getId());
				ps.setFloat(2, buyer.getBalance());
				
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
	
	public boolean update(ArrayList<Buyer> buyers) {
		Connection connection = this.getConneciton();
		try {
			for(Buyer buyer: buyers) {
				String sql = "update buyer set balance = ? where user_id = ?";
				PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
				ps.setFloat(1, buyer.getBalance());
				ps.setInt(2, buyer.getId());
				
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
	
	public Buyer getBuyerById(int id) {
		Connection connection = this.getConneciton();
    	Buyer thisBuyer = null;
    	try {
    		String sql = "select * from buyer where id = ?";
    		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
    		ps.setInt(1, id);
    		
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			thisBuyer = new Buyer();
    			thisBuyer.setId(rs.getInt("user_id"));
    			thisBuyer.setBalnce(rs.getFloat("balance"));
    		}
    		
			this.closeConnection(connection);
			return thisBuyer;

    	}catch(SQLException error) {
    		this.closeConnection(connection);
    		return thisBuyer;
    	}
	}
	
	public boolean changeBalance(int buyerId, float money) {
		Connection connection = this.getConneciton();
		try {
			String sql = "update buyer set balance = balance + "+money+" where user_id = ?";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
    		ps.setInt(1, buyerId);
    		
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
	
	public boolean hasEnoughBalance(int buyerId, float money) {
		Connection connection = this.getConneciton();
		try {
			String sql = "select * from buyer where user_id = ?";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
    		ps.setInt(1, buyerId);
    		
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			if(rs.getFloat("balance") > money) {
    				this.closeConnection(connection);
    				return true;
    			}
    		}
    		
    		this.closeConnection(connection);
    		return false;
		}catch(SQLException error) {
			this.closeConnection(connection);
			return false;
		}
	}
}