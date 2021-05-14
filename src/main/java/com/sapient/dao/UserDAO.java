package com.sapient.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.entity.User;
import com.sapient.entity.UserProfile;
import com.sapient.interfaces.IUserDAO;
import com.sapient.utils.GetConnection;



public class UserDAO implements IUserDAO {



	public boolean registerUser(User user) {

		String sql = "insert into users values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getName());
			ps.setString(5, user.getDob());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return false;
		}



	}

	public boolean loginUser(String email,String password) {

		String sql = "select count(user_id) from users where binary email = ? and binary password = ?";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet resultset = ps.executeQuery();
			resultset.next();
			return resultset.getInt(1)>0; //checking if resultset is empty or not
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	public UserProfile getUser(String userId) {
		// TODO Auto-generated method stub
		String sql = "select user_id,email,name,dob from users where user_id =?";
		
		UserProfile userProfile =new UserProfile();
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//User user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				userProfile.setUserId(rs.getString(1));
				userProfile.setEmail(rs.getString(2));
				userProfile.setName(rs.getString(3));
				userProfile.setDob(rs.getString(4));
			}
			return userProfile;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userProfile;
	}
	
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		String sql = "select * from users";
		List<User> list = null;
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<User>();
			while (rs.next()) {
				User user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
		
	}

	public boolean changePassword(String email, String password) {
		// TODO Auto-generated method stub
		
		String sql = "update users set password=? where email=?";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);		
			int rowsAffected = ps.executeUpdate();
			return rowsAffected==1; //checking if rowAffcted is 1
			} catch (SQLException e) {
			System.out.print(e.getMessage());
		    return false;
		}
	}

	public boolean deleteUser(String email,String password) {
		// TODO Auto-generated method stub
		
		String sql = "DELETE FROM users WHERE email=? AND password=?";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return false;
		}
		
	}

	



}
