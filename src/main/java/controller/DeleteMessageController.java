package controller;

import dto.Message;

public class DeleteMessageController extends Controller{
	public boolean deleteMessage(String msgId) {
		Message thisMsg = new Message();
		thisMsg.setId(Integer.parseInt(msgId));
		return bc.deleteMessage(thisMsg);
	}
}
