package facade;

import java.sql.Date;

import dto.Comment;

public class CommentFacade {
	private Comment comment = new Comment();
	
	public void setComment(int userId, String username, int itemId, String itemName, String content) {
		comment.setUserId(userId);
		comment.setUsername(username);
		comment.setItemId(itemId);
		comment.setItemName(itemName);
		comment.setContent(content);
		comment.setDate(new Date(new java.util.Date().getTime()));

	}
	
	public Comment getCommentData() {
		return comment;
	}
}
