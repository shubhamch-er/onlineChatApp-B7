package com.sapient.learning.chat.interfaces;

import java.util.List;

import com.sapient.learning.chat.entity.Message;

public interface IUserMessageDao {
	public List<Message> getMessages(String userId, String userReceiver);
	public boolean saveNewMessage(Message message);
	public boolean deleteSenderMessage(int messageId);
	public boolean deleteReceiverMessage(int messageId);
}
