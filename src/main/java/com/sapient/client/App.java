package com.sapient.client;

import java.sql.Date;
import java.time.LocalDate;

import com.sapient.dao.MessageRequestDAO;
import com.sapient.dao.UpdateProfileDAO;
import com.sapient.entity.MessageRequest;
import com.sapient.exceptions.AgeLessThan18Exception;
import com.sapient.exceptions.EmailNotValidException;
import com.sapient.exceptions.NameTooSmallException;
import com.sapient.exceptions.PasswordNotStrongException;
import com.sapient.interfaces.IMessageRequestDAO;
import com.sapient.interfaces.IUpdateProfileDAO;

public class App {
	public static void main(String[] args) {
//		MessageRequest m = new MessageRequest();
//		m.setSenderId(10005);
//		m.setReceiverId(10003);
//		m.setMessageBody("Hi");
//		m.setIsAccepted(1);
//
//		IMessageRequestDAO dao = new MessageRequestDAO();
//		IUpdateProfileDAO dao1 = new UpdateProfileDAO();

//		try {
//			System.out.println(dao1.updateName(10001, "User1")? "Name Updated" : "Name Not Updated");
//		} catch (NameTooSmallException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			System.out.println(dao1.updateEmail(10001, "u1@yahoo.com")? "Email Updated" : "Email Not updated");
//		} catch (EmailNotValidException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			System.out.println(dao1.updatePassword(10001, "User3@789")? "Password Updated" : "Password Not updated");
//		} catch (PasswordNotStrongException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			System.out.println(dao1.updateDOB(10001, LocalDate.of(2000, 2, 12))? "DOB Updated" : "DOB Not updated");
//		} catch (AgeLessThan18Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		System.out.println(dao.saveMessage(m) ? "Inserted " : "Not Inserted");
//		System.out.println(dao.getMessage(02));
//		System.out.println(dao.getAllMessages());
//		System.out.println(dao.updateRequest(1, 1) ? "Updated" : "Not updated");
//		
	}

}
