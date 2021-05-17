package com.sapient.entity;

public class MessageRequest {
	private int requestId;
	private int senderId;
	private int receiverId;
	private String messageBody;
	private int isAccepted;

	public MessageRequest() {

	}

	public MessageRequest(int requestId, int senderId, int receiverId, String messageBody, int isAccepted) {
		this.requestId = requestId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.messageBody = messageBody;
		this.isAccepted = isAccepted;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public int getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(int isAccepted) {
		this.isAccepted = isAccepted;
	}

	@Override
	public String toString() {
		return "MessageRequest [requestId=" + requestId + ", senderId=" + senderId + ", receiverId=" + receiverId
				+ ", messageBody=" + messageBody + ", isAccepted=" + isAccepted + "]";
	}

}
