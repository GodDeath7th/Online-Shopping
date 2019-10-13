package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Address;

public class AddressMapper extends Mapper{
    public boolean insert(ArrayList<Address> addresses) {
        Connection connection = this.getConneciton();
        try {
        	for(Address address: addresses) {
        		String sql = "INSERT INTO address (user_id, address, state, country, zip) VALUES (?,?,?,?,?);";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, address.getUserId());
        		ps.setString(2, address.getAddress());
        		ps.setString(3, address.getState());
        		ps.setString(4, address.getCountry());
        		ps.setString(5, address.getZip());
        		
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
    
    public boolean update(ArrayList<Address> addresses) {
        Connection connection = this.getConneciton();
        try {
        	for(Address address: addresses) {
        		String sql = "update address set address = ?, state = ?, country = ?, "
        				+ "zip = ? where id = ?";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setString(1, address.getAddress());
        		ps.setString(2, address.getState());
        		ps.setString(3, address.getCountry());
        		ps.setString(4, address.getZip());
        		ps.setInt(5, address.getId());
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
    
    public boolean delete(ArrayList<Address> addresses) {
        Connection connection = this.getConneciton();
        try {
        	for(Address address: addresses) {
        		String sql = "delete from address where id = ?";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, address.getId());
        		
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
    
    public ArrayList<Address> getAddressByUserId(int userId) {
        Connection connection = this.getConneciton();
        ArrayList<Address> thisUserAddresses = null;
        try {
        	// get address by giving user id
        	String sql = "select * from address where user_id = ?";
        	PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        	ps.setInt(1, userId);
        	
        	ResultSet rs = ps.executeQuery();
        	// if result is not null, package them into data transfer object
        	while(rs.next()) {
        		// lazy load
        		if(thisUserAddresses == null) {
        			thisUserAddresses = new ArrayList<>();
        		}
        		
        		Address thisUserEachAddress = new Address();
        		thisUserEachAddress.setId(rs.getInt("id"));
        		thisUserEachAddress.setUserId(rs.getInt("user_id"));
        		thisUserEachAddress.setAddress(rs.getString("address"));
        		thisUserEachAddress.setState(rs.getString("state"));
        		thisUserEachAddress.setCountry(rs.getString("country"));
        		thisUserEachAddress.setZip(rs.getString("zip"));
        		
        		thisUserAddresses.add(thisUserEachAddress);
        	}
        	
        } catch (SQLException error) {
            this.closeConnection(connection);
            return thisUserAddresses;
        } 
        this.closeConnection(connection);
        return thisUserAddresses;
    }
}
