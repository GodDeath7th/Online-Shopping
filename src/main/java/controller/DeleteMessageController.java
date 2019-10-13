package controller;

import dto.Message;

public class DeleteMessageController extends Controller{
	public boolean deleteMessage(String msgId) {
		// delete a message by giving its id in database
		Message thisMsg = new Message();
		thisMsg.setId(Integer.parseInt(msgId));
		return bc.deleteMessage(thisMsg);
	}
}
