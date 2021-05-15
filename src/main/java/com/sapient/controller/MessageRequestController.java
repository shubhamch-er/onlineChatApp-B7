package com.sapient.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.dao.MessageRequestDAO;
import com.sapient.entity.MessageRequest;
import com.sapient.interfaces.IMessageRequestDAO;

@RestController
@RequestMapping("/api")
public class MessageRequestController {

	private IMessageRequestDAO dao = new MessageRequestDAO();

	@GetMapping("/health")
	public String health() {
		return "Chat Service is UP... ";
	}

	@GetMapping("/messageRequest")
	public List<MessageRequest> getAllMessage() {
		return dao.getAllMessages();
	}

	@GetMapping("/messageRequest/{requestId}")
	public MessageRequest getMessage(@PathVariable int requestId) {
		return dao.getMessage(requestId);
	}

	@PostMapping("/messageRequest")
	public String insertMessage(@RequestBody MessageRequest messageRequest) {
		return dao.saveMessage(messageRequest) ? "Inserted" : "Not Inserted";
	}

	@PutMapping("/updateRequest/{requestId}")
	public String changeRequest(@PathVariable int requestId, @RequestBody MessageRequest messageRequest) {
		return dao.updateRequest(requestId, messageRequest.getIsAccepted()) ? "updated" : "not updated";
	}

}