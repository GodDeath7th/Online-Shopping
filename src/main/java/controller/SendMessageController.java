package controller;


import dto.Message;
import facade.MessageFacade;

public class SendMessageController extends Controller{
	public boolean sendMessage(String fromName, String toName, String content) {
		MessageFacade messageFacade = new MessageFacade();
		messageFacade.setMessage(fromName, toName, content);
		return bc.sendMessage(messageFacade.getMessageData());
	}
}
