package com.sapient.learning.chat.interfaces;

import java.util.List;

import com.sapient.learning.chat.entity.Message;

public interface IGroupMessageDao {
	public List<Message> getMessages(String userId, int groupReceiver);
	public boolean saveNewMessage(Message message);
}
