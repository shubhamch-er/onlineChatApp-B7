package com.sapient.learning.chat.client;

import java.util.ArrayList;
import java.util.List;

import com.sapient.learning.chat.dao.*;
import com.sapient.learning.chat.entity.Message;

public class App {
	public static void main(String[] args) {
//		UserMessagesDao userMessageObject = new UserMessagesDao();
//		List<Message> res = userMessageObject.getMessages("U1", "U2");
		GroupMessagesDao groupMessageObject = new GroupMessagesDao();
		List<Message> res = groupMessageObject.getMessages("U1", 1);
		System.out.println(res);
//		Message message = new Message();
//		message.setSenderId("U3");
//		message.setGroupReceiverId(1);
//		message.setMessageBody("Reply to a message");
//		message.setReplyToAMessage(7);
//		System.out.println(groupMessageObject.saveNewMessage(message));
//		System.out.println(userMessageObject.deleteSenderMessage(22));
		
	}
}
