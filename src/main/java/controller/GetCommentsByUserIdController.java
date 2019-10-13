package controller;

import java.util.ArrayList;

import dto.Comment;

public class GetCommentsByUserIdController extends Controller{
	// get all comments for an user and set display style to front end
	public String getCommentByUserId(String userId) {
		String htmlText = "";
		ArrayList<Comment> thisUserComments = bc.getCommentsByUserId(Integer.parseInt(userId));
		if(thisUserComments == null) {
			htmlText = "<div class = 'container' style = 'width:800px; margin:100px auto'><p align='center'>No comment now.</p></div>";
		}
		else {
			htmlText = htmlText + "<div class = 'container' style = 'width:800px; margin:100px auto'>";
			for(Comment thisUserEachComment: thisUserComments) {
				htmlText = htmlText + "<div class = 'container border border-dark rounded' style='margin:20px auto'>";
				htmlText = htmlText + "<p>Item name: "+thisUserEachComment.getItemName()+"</p>";
				htmlText = htmlText + "<p>Content: "+thisUserEachComment.getContent()+"</p>";
				htmlText = htmlText + "<p>Date: "+thisUserEachComment.getDate()+"</p>";
				htmlText = htmlText + "<div class = 'row' style = 'margin:10px auto'>";
				htmlText = htmlText + "<a class = 'btn btn-danger' style = 'margin:5px' href = 'comment-delete-process.jsp?comment_id="+thisUserEachComment.getId()+"'>Delete</a>";
				htmlText = htmlText + "</div></div>";
			}
			htmlText = htmlText + "</div>";
		}
		
		return htmlText;
	}
}
