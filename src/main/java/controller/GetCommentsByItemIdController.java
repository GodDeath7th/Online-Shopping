package controller;

import java.util.ArrayList;

import dto.Comment;

public class GetCommentsByItemIdController extends Controller{
	// get all comments for an item and set display style to front end
	public String getCommentByItemId(String itemId) {
		String htmlText = "";
		ArrayList<Comment> thisItemComments = bc.getCommentsByItemId(Integer.parseInt(itemId));
		if(thisItemComments == null) {
			htmlText = "<div class = 'container' style = 'width:800px; margin:100px auto'><p align='center'>No comment now.</p></div>";
		}
		else {
			for(Comment thisItemEachComment: thisItemComments) {
				htmlText = htmlText + "<div class = 'container' style='margin:20px auto'>";
				htmlText = htmlText + "<p>User: "+thisItemEachComment.getUsername()+"</p>";
				htmlText = htmlText + "<p>Content: "+thisItemEachComment.getContent()+"</p>";
				htmlText = htmlText + "<p>"+thisItemEachComment.getDate()+"</p>";
				htmlText = htmlText + "<p>-----------------------------------------------------------------------------------------------------</p>";
				htmlText = htmlText + "</div>";
			}
		}		
		return htmlText;
	}
}
