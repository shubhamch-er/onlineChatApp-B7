package com.sapient.interfaces;

import java.util.List;

import com.sapient.entity.User;
import com.sapient.entity.UserProfile;

public interface IUserDAO {
	
	public boolean registerUser(User user);
	
	public boolean loginUser(String email,String password);
	
	public UserProfile getUser(String userId);
	
	public boolean changePassword(String email,String password);
	
	public boolean deleteUser(String email,String password);
	
	public List<User> getAllUsers();
	

}