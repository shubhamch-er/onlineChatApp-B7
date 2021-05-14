package com.sapient.chat;


//import static org.junit.Assert.*;
//import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sapient.chat.dao.MessageRequestDAO;
import com.sapient.chat.dao.UpdateProfileDAO;
import com.sapient.chat.entity.MessageRequest;
import com.sapient.chat.exceptions.EmailNotValidException;
import com.sapient.chat.exceptions.NameTooSmallException;
import com.sapient.chat.interfaces.IMessageRequestDAO;
import com.sapient.chat.interfaces.IUpdateProfileDAO;

public class PodOneTest {

	private MessageRequest m = null;
	private IMessageRequestDAO dao = null;
	private IUpdateProfileDAO dao1 = null;
	
	@BeforeEach
	public void setUp() {
		m = new MessageRequest();
		dao = new MessageRequestDAO(); 
		dao1 = new UpdateProfileDAO();

		m.setSenderId(10005);
		m.setReceiverId(10003);
		
		m.setMessageBody("Hi");
		m.setIsAccepted(1);
	}
	
	@Test
	@DisplayName("Message Post Test")
	public void messagePostTest() {
		assertEquals(true , dao.saveMessage(m));
	}
	
	@Test
	@DisplayName("Sender Id Test")
	public void isSenderIDCorrect() {
		assertEquals(10005 , m.getSenderId());
	}
	
	@Test
	@DisplayName("Receiver Id Test")
	public void isRecieverIDCorrect() {
		assertEquals(10003 , m.getReceiverId());
	}
	
	@Test
	@DisplayName("Get All Message Test")
	public void getAllMessages() {
		assertNotEquals(0 , dao.getAllMessages().size());
	}
	
	@Test
	@DisplayName("name Update Test")
	public void isNameUpdatedCorrectly() throws NameTooSmallException {
		assertEquals(false , dao1.updateName(124, "ABC"));
	}
	
	@Test
	@DisplayName("Email Update Test")
	public void isEmailUpdatedCorrectly() throws EmailNotValidException {
		assertEquals(false , dao1.updateEmail(124, "abc@gmail.com"));
	}
}
