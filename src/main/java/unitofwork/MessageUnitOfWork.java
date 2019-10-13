package unitofwork;

import java.util.ArrayList;

import datasource.MessageMapper;
import dto.Message;

public class MessageUnitOfWork {
	private ArrayList<Message> newMessages;
	private ArrayList<Message> deleteMessages;
	private MessageMapper messageMapper;
	
	public MessageUnitOfWork() {
		messageMapper = new MessageMapper();
	}
	
	public boolean addMessage(Message message, boolean instantCommit) {
		if(newMessages == null) {
			newMessages = new ArrayList<>();
		}
		newMessages.add(message);
		
		if(instantCommit) {
			return doCommit()[0];
		}
		return true;
	}
	
	public boolean deleteMessage(Message message, boolean instantCommit) {
		if(deleteMessages == null) {
			deleteMessages = new ArrayList<>();
		}
		deleteMessages.add(message);
		
		if(instantCommit) {
			return doCommit()[1];
		}
		
		return true;
	}
	
	// get message by a range, what is range can be found in message mapper
	public ArrayList<Message> getMessagesByRange(String range, String[] parameters){
		ArrayList<Message>  thisRangeMessages = messageMapper.getMessagesByRange(range, parameters);
		return thisRangeMessages;
	}
	public boolean[] doCommit() {
		boolean isNewSuccess = true;
		boolean isDeleteSuccess = true;
		
		if(newMessages != null) {
			if(newMessages.size() > 0) {
				if(messageMapper.insert(newMessages)){
					newMessages.clear();
				}
				else {
					isNewSuccess = false;
				}
			}
		}
		
		if(deleteMessages != null) {
			if(deleteMessages.size() > 0 ) {
				if(messageMapper.delete(deleteMessages)) {
					deleteMessages.clear();
				}
				else {
					isDeleteSuccess = false;
				}
			}
		}
		
		return new boolean[] {isNewSuccess, isDeleteSuccess};
	}
}