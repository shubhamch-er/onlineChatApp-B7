package com.sapient.chat.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.chat.entity.MessageRequest;
import com.sapient.chat.interfaces.IMessageRequestDAO;
import com.sapient.chat.utils.GetConnection;

public class MessageRequestDAO implements IMessageRequestDAO {

	public boolean saveMessage(MessageRequest messageRequest) {
		String sql = "insert into messagerequest values(default,?,?,?,?)";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, messageRequest.getSenderId());
			ps.setInt(2, messageRequest.getReceiverId());
			ps.setString(3, messageRequest.getMessageBody());
			ps.setInt(4, messageRequest.getIsAccepted());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public MessageRequest getMessage(int requestId) {
		String sql = "select request_id, sender_id, receiver_id, message_body, is_accepted from messagerequest where request_id = ?";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, requestId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				MessageRequest messageRequest = new MessageRequest();
				messageRequest.setSenderId(rs.getInt(2));
				messageRequest.setReceiverId(rs.getInt(3));
				messageRequest.setMessageBody(rs.getString(4));
				messageRequest.setIsAccepted(rs.getInt(5));
				return messageRequest;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<MessageRequest> getAllMessages() {
		String sql = "select request_id, sender_id, receiver_id, message_body, is_accepted from messagerequest";
		List<MessageRequest> list = null;
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<MessageRequest>();
			while (rs.next()) {
				MessageRequest messageRequest = new MessageRequest();
				messageRequest.setSenderId(rs.getInt(2));
				messageRequest.setReceiverId(rs.getInt(3));
				messageRequest.setMessageBody(rs.getString(4));
				messageRequest.setIsAccepted(rs.getInt(5));
				list.add(messageRequest);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateRequest(int requestId, int isAccepted) {
		String sql = "update messagerequest set is_accepted = ? where request_id = ?";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, isAccepted);
			ps.setInt(2, requestId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
