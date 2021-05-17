package com.sapient.learning.chat.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sapient.learning.chat.dao.UserMessagesDao;
import com.sapient.learning.chat.entity.Message;

//GET /api/messages/U1/U2
//POST /api/messages/U1/U2
//POST /api/messages/U3/U4/
//PATCH /api/messages/83/U4

@RestController
@RequestMapping("/api/messages")
public class UserMessageController {
	
	private UserMessagesDao userMessages = new UserMessagesDao();
	
	@GetMapping("/{senderId}/{receiverId}")
	public List<Message> getMessages(@PathVariable String senderId, @PathVariable String receiverId) {
		return userMessages.getMessages(senderId, receiverId);
	}
	
	@PostMapping("/{senderId}/{receiverId}")
	public boolean saveMessage(@PathVariable String senderId, @PathVariable String receiverId, @RequestBody String messageBody) {
		Message message = new Message();
		message.setSenderId(senderId);
		message.setUserReceiverId(receiverId);
		message.setMessageBody(messageBody);
		return userMessages.saveNewMessage(message);
	}
	
	@PostMapping("/{senderId}/{receiverId}/{messageId}")
	public boolean replyToAMessage(@PathVariable int messageId, @PathVariable String senderId, @PathVariable String receiverId, @RequestBody String messageBody) {
		Message message = new Message();
		message.setSenderId(senderId);
		message.setUserReceiverId(receiverId);
		message.setMessageBody(messageBody);
		message.setReplyToAMessage(messageId);
		return userMessages.saveNewMessage(message);
	}
	
	@PatchMapping("/{messageId}/{userId}")
	public boolean updateMessageDeletion(@PathVariable int messageId, @PathVariable String userId) {
		Message message = userMessages.getMessageById(messageId);
		boolean sender = (message.getSenderId().equals(userId));
		if (sender) {
			return userMessages.deleteSenderMessage(messageId);
		} else {
			return userMessages.deleteReceiverMessage(messageId);
		}
	}
}
