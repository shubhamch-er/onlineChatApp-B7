package com.sapient.entity;

public class Message {
	private int mId;
	private int senderId; 
	private int recevrId; 
	private String message; 
	private String isAccepted; 
	
	public Message() {
	}

	public Message(int mId, int senderId, int recevrId, String message, String isAccepted) {
		super();
		this.mId = mId;
		this.senderId = senderId;
		this.recevrId = recevrId;
		this.message = message;
		this.isAccepted = isAccepted;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getRecevrId() {
		return recevrId;
	}

	public void setRecevrId(int recevrId) {
		this.recevrId = recevrId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(String isAccepted) {
		this.isAccepted = isAccepted;
	}

	@Override
	public String toString() {
		return "Message [mId=" + mId + ", senderId=" + senderId + ", recevrId=" + recevrId + ", message=" + message
				+ ", isAccepted=" + isAccepted + "]";
	}
	
	
	
	
	
}
