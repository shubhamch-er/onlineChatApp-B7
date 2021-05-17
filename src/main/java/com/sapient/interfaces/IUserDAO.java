package com.sapient.interfaces;

import java.util.List;

import com.sapient.entity.User;
import com.sapient.entity.UserProfile;
import com.sapient.params.DeleteUserParams;
import com.sapient.params.Loginparams;

public interface IUserDAO {
	
	public boolean registerUser(User user);
	
	public boolean loginUser(Loginparams params);
	
	public UserProfile getUser(String userId);
	
	public boolean deleteUser(DeleteUserParams params);
	
	public List<UserProfile> getAllUsers();
	

}