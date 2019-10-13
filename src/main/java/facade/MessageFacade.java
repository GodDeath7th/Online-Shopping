package facade;

import java.sql.Date;

import dto.Message;

public class MessageFacade {
	public Message message = new Message();
	public void setMessage(String fromName,String toName, String content) {
		message.setFromName(fromName);
		message.setToName(toName);
		message.setContent(content);
		message.setDate(new Date(new java.util.Date().getTime()));
	}
	
	public Message getMessageData() {
		return message;
	}
}
