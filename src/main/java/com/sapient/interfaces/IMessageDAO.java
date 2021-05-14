package com.sapient.interfaces;

import java.util.List;

import com.sapient.entity.Message;

public interface IMessageDAO {
	// save 
	public boolean saveMessage(Message message); 
	
	// get message
	public Message getMessage(int mId); 
	
	// get all messages
	public List<Message> getAllMessages(); 
}
