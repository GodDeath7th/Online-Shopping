package controller;

import dto.Comment;

public class DeleteCommentController extends Controller{
	public boolean deleteComment(String commentId) {
		// delete a comment by giving its id in database
		Comment thisComment = new Comment();
		thisComment.setId(Integer.parseInt(commentId));
		return bc.deleteComment(thisComment);
	}
}
