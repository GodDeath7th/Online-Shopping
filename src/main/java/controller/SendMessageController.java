package controller;


import facade.MessageFacade;

public class SendMessageController extends Controller{
	// send message to buyer/seller by invoking behavior conductor
	public boolean sendMessage(String fromName, String toName, String content) {
		MessageFacade messageFacade = new MessageFacade();
		messageFacade.setMessage(fromName, toName, content);
		return bc.sendMessage(messageFacade.getMessageData());
	}
}
