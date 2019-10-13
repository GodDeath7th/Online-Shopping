package controller;

import java.util.ArrayList;

import dto.Message;
import dto.SellerOrientedItem;

public class GetReceiveMessagesController extends Controller{
	public String GetReceiveMessages(String toName) {
		ArrayList<Message> thisUserRecvMsg = bc.getReceiveMessages(toName);
		String htmlText = "";
		// return html to page
		if(thisUserRecvMsg == null) {
			htmlText = "<div class = 'container' style = 'width:800px; margin:100px auto'><p align='center'>No receive message.</p></div>";
		}
		else {
			htmlText = "<div class = 'container' style = 'width:800px; margin:100px auto'>";
			for(Message eachRecvMsg: thisUserRecvMsg) {
				htmlText = htmlText + "<div class = 'container rounded border border-dark' style='margin:20px auto'>";
				htmlText = htmlText + "<p>From: "+eachRecvMsg.getFromName()+"</p>";
				htmlText = htmlText + "<p>Content: "+eachRecvMsg.getContent()+"</p>";
				htmlText = htmlText + "<p>Date: "+eachRecvMsg.getDate()+"</p>";
				htmlText = htmlText + "<div class = 'row' style = 'margin:10px auto'>";
				htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'send-message.jsp?to_name="+eachRecvMsg.getFromName()+"'>Reply</a>";
				htmlText = htmlText + "<a class = 'btn btn-danger' style = 'margin:5px' href = 'message-delete-process.jsp?message_id="+eachRecvMsg.getId()+"&from_url=receive_message'>Delete</a>";
				htmlText = htmlText + "</div></div>";			
			}
			htmlText = htmlText+"</div>";
		}		
		return htmlText;
	}
}
