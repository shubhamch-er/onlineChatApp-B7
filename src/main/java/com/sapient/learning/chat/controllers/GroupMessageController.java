package com.sapient.learning.chat.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sapient.learning.chat.dao.GroupMessagesDao;
import com.sapient.learning.chat.entity.Message;

//GET /api/messages/group/U1/1 
//POST /api/messages/group/U1/1
//POST /api/messages/group/U1/1/7

@RestController
@RequestMapping("/api/messages/group")
public class GroupMessageController {
	GroupMessagesDao groupMessages = new GroupMessagesDao();
	
	@GetMapping("/{senderId}/{receiverId}")
	public List<Message> getMessages(@PathVariable String senderId, @PathVariable int receiverId) {
		return groupMessages.getMessages(senderId, receiverId);
	}
	
	@PostMapping("/{senderId}/{receiverId}")
	public boolean saveMessage(@PathVariable String senderId, @PathVariable int receiverId, @RequestBody String messageBody) {
		Message message = new Message();
		message.setSenderId(senderId);
		message.setGroupReceiverId(receiverId);
		message.setMessageBody(messageBody);
		return groupMessages.saveNewMessage(message);
	}
	
	@PostMapping("/{senderId}/{receiverId}/{messageId}")
	public boolean replyToAMessage(@PathVariable int messageId, @PathVariable String senderId, @PathVariable int receiverId, @RequestBody String messageBody) {
		Message message = new Message();
		message.setSenderId(senderId);
		message.setGroupReceiverId(receiverId);
		message.setMessageBody(messageBody);
		message.setReplyToAMessage(messageId);
		return groupMessages.saveNewMessage(message);
	}
}
