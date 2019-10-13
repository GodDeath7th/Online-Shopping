package controller;

import facade.CommentFacade;

public class MakeCommentController extends Controller{
	public boolean makeComment(String userId, String username, String itemId, String itemName, String content) {
		CommentFacade commentFacade = new CommentFacade();
		commentFacade.setComment(Integer.parseInt(userId), username, Integer.parseInt(itemId), itemName, content);

		return bc.makeComment(commentFacade.getCommentData());
	}
}
