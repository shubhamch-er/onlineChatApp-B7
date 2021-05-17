package com.sapient.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.entity.User;
import com.sapient.entity.UserProfile;
import com.sapient.interfaces.IUserDAO;
import com.sapient.params.ChangePasswordParams;
import com.sapient.params.DeleteUserParams;
import com.sapient.params.Loginparams;
import com.sapient.utils.GetConnection;



public class UserDAO implements IUserDAO {



	public boolean registerUser(User user) {

		String sql = "INSERT INTO users VALUES(?,?,?,?,?)";
		
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

	public boolean loginUser(Loginparams params) {

		String sql = "SELECT COUNT(user_id) FROM users WHERE BINARY email = ? AND BINARY password = ?";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, params.getEmail());
			ps.setString(2, params.getPassword());
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
		String sql = "SELECT user_id,email,name,dob FROM users WHERE user_id =?";
		
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
	
	public List<UserProfile> getAllUsers() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USERS WHERE isdeleted=0";
		List<UserProfile> list = null;
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<UserProfile>();
			while (rs.next()) {
				UserProfile userProfile = new UserProfile(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(5));
				list.add(userProfile);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}


	public boolean deleteUser(DeleteUserParams params) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE users SET isdeleted= true WHERE email=? AND password=?";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, params.getEmail());
			ps.setString(2, params.getPassword());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return false;
		}
		
	}

}
