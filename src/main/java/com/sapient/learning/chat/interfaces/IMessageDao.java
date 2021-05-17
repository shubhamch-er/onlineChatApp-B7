package com.sapient.learning.chat.interfaces;

import java.util.List;
import com.sapient.learning.chat.entity.Message;

public interface IMessageDao {
	public List<Message> getMessagesOfAConversation(String senderId, String userReceiverId, int groupReceiverId);
	public boolean saveNewMessage(Message message);
}
