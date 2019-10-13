package datasource;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Message;;

public class MessageMapper extends Mapper{
	public boolean insert(ArrayList<Message> messages) {
        Connection connection = this.getConneciton();
        try {
        	for(Message message: messages) {
        		String sql = "insert into message (from_name, to_name, content, date) values (?,?,?,?)";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setString(1, message.getFromName());
        		ps.setString(2, message.getToName());
        		ps.setString(3, message.getContent());
        		ps.setDate(4, message.getDate());
        		
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
       
	public boolean delete(ArrayList<Message> messages) {
        Connection connection = this.getConneciton();
        try {
        	for(Message message: messages) {
        		String sql = "delete from message where id = ?";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, message.getId());

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
        
    public ArrayList<Message> getMessagesByRange(String range, String[] parameters) {
        Connection connection = this.getConneciton();
        ArrayList<Message> thisRangeMessages = null;
        try {
        	PreparedStatement ps = null;
        	String sql = null;
        	if(range.equals("FROM_NAME")) {
        		sql = "select * from message where from_name = ?";
        		ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setString(1, parameters[0]);
        	}
        	else if(range.equals("TO_NAME")) {
        		sql = "select * from message where to_name = ?";
        		ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setString(1, parameters[0]);
        	}
        	else {
        		this.closeConnection(connection);
        		return null;
        	}
        	
        	ResultSet rs = ps.executeQuery();
        	while(rs.next()) {
        		if(thisRangeMessages == null) {
        			thisRangeMessages = new ArrayList<>();
        		}
        		
        		Message thisRangeEachMessage = new Message();
        		thisRangeEachMessage.setId(rs.getInt("id"));
        		thisRangeEachMessage.setFromName(rs.getString("from_name"));
        		thisRangeEachMessage.setToName(rs.getString("to_name"));
        		thisRangeEachMessage.setContent(rs.getString("content"));
        		thisRangeEachMessage.setDate(rs.getDate("date"));
        		
        		thisRangeMessages.add(thisRangeEachMessage);
        	}
        	 this.closeConnection(connection);
             return thisRangeMessages;
        	
        } catch (SQLException error) {
            this.closeConnection(connection);
            return thisRangeMessages;
        } 
    }
}
