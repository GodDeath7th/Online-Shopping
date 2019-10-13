package datasource;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databaseconnection.DatabaseAccess;
import dto.User;
import dto.UserAuthentication;

public class UserAuthMapper extends Mapper{
	
	public boolean addUserAuth(ArrayList<UserAuthentication> userAuths) {
        Connection connection = this.getConneciton();
        try {
        	for(UserAuthentication userAuth: userAuths) {
        		String sql = "insert into member_auth (user_id, phone_number, password, user_type) values (?,?,?,?)";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, userAuth.getUserId());
        		ps.setString(2, userAuth.getPhoneNumber());
        		ps.setString(3, userAuth.getPassword());
        		ps.setString(4, userAuth.getUserType());
        		
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
	
	public UserAuthentication getUserAuthByAuthUnits(String phoneNumber, String password, String userType) {
		Connection connection = this.getConneciton();
		try {
			String sql = "select * from member_auth where phone_number = ? and password = ? and user_type = ?";
			PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
			ps.setString(1, phoneNumber);
			ps.setString(2, password);
			ps.setString(3, userType);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserAuthentication thisUserAuth = new UserAuthentication();
				thisUserAuth.setId(rs.getInt("id"));
				thisUserAuth.setUserId(rs.getInt("user_id"));
				thisUserAuth.setPhoneNumber(rs.getString("phone_number"));
				thisUserAuth.setUserType(rs.getString("user_type"));
				
				return thisUserAuth;
			}
			
			return null;
		}catch(SQLException error) {
			this.closeConnection(connection);
			return null;
		}
	}
}
