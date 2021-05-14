package com.sapient.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.entity.Message;
import com.sapient.interfaces.IMessageDAO;
import com.sapient.utils.GetConnection;

public class MessageDAO implements IMessageDAO {

	public boolean saveMessage(Message message) {
		String sql = "insert into message values(?,?,?,?,?)";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, message.getmId());
			ps.setInt(2, message.getSenderId());
			ps.setInt(3, message.getRecevrId());
			ps.setString(4, message.getMessage());
			ps.setString(5, message.getIsAccepted());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		  return false;
	}

	public Message getMessage(int mId) {

		String sql = "select messageid,senderid,receiverid,message," + "isAccepted from message where messageid = ?";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, mId);
			// CTRL + 2 + L
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				Message message = new Message();
				message.setmId(rs.getInt(1));
				message.setSenderId(rs.getInt(2));
				message.setRecevrId(rs.getInt(3));
				message.setMessage(rs.getString(4));
				message.setIsAccepted(rs.getString(5));

				return message;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public List<Message> getAllMessages() {
		String sql = "select messageid,senderid,receiverid,message," + "isAccepted from message";
		List<Message> list = null;
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<Message>();
			while (rs.next()) {
				Message message = new Message();
				message.setmId(rs.getInt(1));
				message.setSenderId(rs.getInt(2));
				message.setRecevrId(rs.getInt(3));
				message.setMessage(rs.getString(4));
				message.setIsAccepted(rs.getString(5));
				
				list.add(message);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
