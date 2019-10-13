package datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Comment;

public class CommentMapper extends Mapper{
	public boolean insert(ArrayList<Comment> comments) {
        Connection connection = this.getConneciton();
        try {
        	for(Comment comment: comments) {
        		String sql = "insert into comment (user_id, username, item_id, item_name, content, date) VALUES (?,?,?,?,?,?)";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, comment.getUserId());
        		ps.setString(2, comment.getUsername());
        		ps.setInt(3, comment.getItemId());
        		ps.setString(4, comment.getItemName());
        		ps.setString(5, comment.getContent());
        		ps.setDate(6, comment.getDate());
        		
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
    
	public boolean delete(ArrayList<Comment> comments) {
        Connection connection = this.getConneciton();
        try {
        	for(Comment comment: comments) {
        		String sql = "delete from comment where id = ?";
        		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, comment.getId());
        		
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
    
    public ArrayList<Comment> getCommentsByRange(String range, String[] parameters) {
        Connection connection = this.getConneciton();
        ArrayList<Comment> thisRangeComments = null;
        
        try {
        	connection = this.getConneciton();
    		PreparedStatement ps = null;
    		String sql = null;
    		if(range.equals("USER_ID")) {
    			sql = "select * from comment where user_id = ?";
        		ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, Integer.parseInt(parameters[0]));
    		}
    		else if(range.equals("ITEM_ID")) {
    			sql = "select * from comment where item_id = ?";
    			ps = (PreparedStatement) connection.prepareStatement(sql);
        		ps.setInt(1, Integer.parseInt(parameters[0]));
    		}
        	
        	ResultSet rs = ps.executeQuery();
        	while(rs.next()) {
        		if(thisRangeComments == null) {
        			thisRangeComments = new ArrayList<>();
        		}
        		
        		Comment thisRangeEachComment = new Comment();
        		thisRangeEachComment.setId(rs.getInt("id"));
        		thisRangeEachComment.setUserId(rs.getInt("user_id"));
        		thisRangeEachComment.setUsername(rs.getString("username"));
        		thisRangeEachComment.setItemId(rs.getInt("item_id"));
        		thisRangeEachComment.setItemName(rs.getString("item_name"));
        		thisRangeEachComment.setContent(rs.getString("content"));
        		thisRangeEachComment.setDate(rs.getDate("date"));
        		
        		thisRangeComments.add(thisRangeEachComment);
        	}
        	this.closeConnection(connection);
            return thisRangeComments;
        	
        } catch (SQLException error) {
            this.closeConnection(connection);
            return thisRangeComments;
        } 
    }   
}