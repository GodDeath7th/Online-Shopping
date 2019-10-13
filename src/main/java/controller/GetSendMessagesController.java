package controller;

import java.util.ArrayList;

import dto.Message;

public class GetSendMessagesController extends Controller{
	public String GetSendMessages(String fromName) {
		ArrayList<Message> thisUserSendMsg = bc.getSendMessages(fromName);
		String htmlText = "";
		// return html to page
		if(thisUserSendMsg == null) {
			htmlText = htmlText + "<div class = 'container' style = 'width:800px; margin:100px auto'><p align='center'>No send message.</p></div>";
			htmlText = htmlText + "<div class = 'container' style = 'width:100px; margin:100px auto'><a class = 'btn btn-success' href='send-message.jsp'>Send</a></div>";
		}
		else {
			htmlText = "<div class = 'container' style = 'width:800px; margin:100px auto'>";
			for(Message eachSendMsg: thisUserSendMsg) {
				htmlText = htmlText + "<div class = 'container rounded border border-dark' style='margin:20px auto'>";
				htmlText = htmlText + "<p>To: "+eachSendMsg.getToName()+"</p>";
				htmlText = htmlText + "<p>Content: "+eachSendMsg.getContent()+"</p>";
				htmlText = htmlText + "<p>Date $"+eachSendMsg.getDate()+"</p>";
				htmlText = htmlText + "<div class = 'row' style = 'margin:10px auto'>";
				htmlText = htmlText + "<a class = 'btn btn-success' style = 'margin:5px' href = 'send-message.jsp?to_name="+eachSendMsg.getToName()+"'>One more</a>";
				htmlText = htmlText + "<a class = 'btn btn-danger' style = 'margin:5px' href = 'message-delete-process.jsp?message_id="+eachSendMsg.getId()+"&from_url=send_message'>Delete</a>";
				htmlText = htmlText + "</div></div>";			
			}
			htmlText = htmlText+"</div>";
		}		
		return htmlText;
	}
}
