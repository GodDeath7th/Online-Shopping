package datasource;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databaseconnection.DatabaseAccess;
import dto.User;


public class UserMapper extends Mapper{
    
    public boolean insert(ArrayList<User> users) {
    	Connection connection = this.getConneciton();
        try {
            for(User user: users) {
            	if(!this.isUserExisted(user)) {
            		String sql = "insert into member(username, password, phone_number, date, user_type)values(?,?,?,?,?);";
            		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            		ps.setString(1, user.getUsername());
            	    ps.setString(2, user.getPassword());
            		ps.setString(3, user.getPhoneNumber());
            		ps.setDate(4, user.getDate());
            		ps.setString(5, user.getUserType());
            		if(ps.executeUpdate() == 0) {
            			this.closeConnection(connection);
            			return false;
            		}
            	}
            }
            this.closeConnection(connection);
        	return true;

        } catch (SQLException e) {
            this.closeConnection(connection);
            return false;
        } 
    }
    
    public boolean update(ArrayList<User> users) {
    	Connection connection = this.getConneciton();
        try {
            for(User user: users) {
            	String sql = "update member set username = ?"
            			+ " where id = ?";
            	PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            	ps.setString(1, user.getUsername());
            	ps.setInt(2, user.getId());
            	if(ps.executeUpdate() == 0) {
            		this.closeConnection(connection);
            		return false;
            	}
            }
            this.closeConnection(connection);
        	return true;

        } catch (SQLException e) {
            this.closeConnection(connection);
            return false;
        } 
    }
    
    public User getUserById(int id) {
    	Connection connection = this.getConneciton();
    	User thisUser = null;
    	try {
    		String sql = "select * from member where id = ?";
    		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
    		ps.setInt(1, id);
    		
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			thisUser = new User();
    			thisUser.setId(rs.getInt("id"));
    			thisUser.setUsername(rs.getString("username"));
    			thisUser.setPassword(rs.getString("password"));
    			thisUser.setPhoneNumber(rs.getString("phone_number"));
    			thisUser.setDate(rs.getDate("date"));
    			thisUser.setUserType(rs.getString("user_type"));
    		}
    		
			this.closeConnection(connection);
			return thisUser;

    	}catch(SQLException error) {
    		this.closeConnection(connection);
    		return thisUser;
    	}
    }
    
    public User getUserByPair(String phoneNumber, String userType) {
    	Connection connection = this.getConneciton();
    	User thisUser = null;
    	try {
    		String sql = "select * from member where phone_number = ? and user_type = ?";
    		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
    		ps.setString(1, phoneNumber);
    		ps.setString(2, userType);
    		
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			thisUser = new User();
    			thisUser.setId(rs.getInt("id"));
    			thisUser.setUsername(rs.getString("username"));
    			thisUser.setPassword(rs.getString("password"));
    			thisUser.setPhoneNumber(rs.getString("phone_number"));
    			thisUser.setDate(rs.getDate("date"));
    			thisUser.setUserType(rs.getString("user_type"));
    		}
    		
			this.closeConnection(connection);
			return thisUser;

    	}catch(SQLException error) {
    		this.closeConnection(connection);
    		return thisUser;
    	}
    }
    
    public boolean isNameUsed(User user) {
    	Connection connection = this.getConneciton();
    	try {
    		String sql = "select * from member where username = ?";
    		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
    		ps.setString(1, user.getUsername());
    		
    		// if this user already being registered return true, else return false
    		if(ps.executeQuery().next()) {
    			this.closeConnection(connection);
    			return true;
    		}
    		else {
    			return false;
    		}
    		
    	}catch (SQLException e) {
            this.closeConnection(connection);
            return false;
        } 
    }
    
    public boolean isUserExisted(User user) {
    	Connection connection = this.getConneciton();
    	try {
    		String sql = "select * from member where phone_number = ? and user_type = ?";
    		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
    		ps.setString(1, user.getPhoneNumber());
    		ps.setString(2, user.getUserType());
    		
    		// if this user already being registered return true, else return false
    		if(ps.executeQuery().next()) {
    			this.closeConnection(connection);
    			return true;
    		}
    		else {
    			return false;
    		}
    		
    	}catch (SQLException e) {
            this.closeConnection(connection);
            return false;
        } 
    }
   
}
