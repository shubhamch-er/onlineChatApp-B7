package com.sapient.learning.chat.entity;


public class Message {
	private int messageId;
	private String senderId;
	private String userReceiverId;
	private int groupReceiverId;
	private String timeOfMessaging;
	private String messageBody;
	private int deletedSender;
	private int deletedReceiver;
	private int replyToAMessage;
	
	public Message(int messageId, String senderId, String userReceiverId, int groupReceiverId, String timeOfMessaging,
			String messageBody, int deletedSender, int deletedReceiver, int replyToAMessage) {
		super();
		this.messageId = messageId;
		this.senderId = senderId;
		this.userReceiverId = userReceiverId;
		this.groupReceiverId = groupReceiverId;
		this.timeOfMessaging = timeOfMessaging;
		this.messageBody = messageBody;
		this.deletedSender = deletedSender;
		this.deletedReceiver = deletedReceiver;
		this.replyToAMessage = replyToAMessage;
	}
	public Message() {
		super();
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getUserReceiverId() {
		return userReceiverId;
	}
	public void setUserReceiverId(String userReceiverId) {
		this.userReceiverId = userReceiverId;
	}
	public int getGroupReceiverId() {
		return groupReceiverId;
	}
	public void setGroupReceiverId(int groupReceiverId) {
		this.groupReceiverId = groupReceiverId;
	}
	public String getTimeOfMessaging() {
		return timeOfMessaging;
	}
	public void setTimeOfMessaging(String timeOfMessaging) {
		this.timeOfMessaging = timeOfMessaging;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public int isDeletedSender() {
		return deletedSender;
	}
	public void setDeletedSender(int deletedSender) {
		this.deletedSender = deletedSender;
	}
	public int isDeletedReceiver() {
		return deletedReceiver;
	}
	public void setDeletedReceiver(int deletedReceiver) {
		this.deletedReceiver = deletedReceiver;
	}
	public int getReplyToAMessage() {
		return replyToAMessage;
	}
	public void setReplyToAMessage(int replyToAMessage) {
		this.replyToAMessage = replyToAMessage;
	}
	@Override
	public String toString() {
		return "message [messageId=" + messageId + ", senderId=" + senderId + ", userReceiverId=" + userReceiverId
				+ ", groupReceiverId=" + groupReceiverId + ", timeOfMessaging=" + timeOfMessaging + ", messageBody="
				+ messageBody + ", deletedSender=" + deletedSender + ", deletedReceiver=" + deletedReceiver
				+ ", replyToAMessage=" + replyToAMessage + "]";
	}
}
