package com.sapient.chat.interfaces;

import java.util.List;

import com.sapient.chat.entity.MessageRequest;

public interface IMessageRequestDAO {
	//save
	public boolean saveMessage(MessageRequest messageRequest );
	
	//getMessage
	public MessageRequest getMessage(int request_id);
	
	//get all messages
	public List<MessageRequest> getAllMessages();
	
	//update a request
	public boolean updateRequest(int request_id, int is_accepted);
}
