package com.sapient.chatapp;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.dao.UserDAO;
import com.sapient.entity.User;
import com.sapient.entity.UserProfile;
import com.sapient.interfaces.IUserDAO;
import com.sapient.params.ChangePasswordParams;
import com.sapient.params.DeleteUserParams;
import com.sapient.params.Loginparams;

/*
 * @Author  Shubham Chaudhari
 */

// http://localhsot:8080/health 
// http://localhost:8080/api/message - GET 
//http://localhost:8080/api/message/101 - GET
//http://localhost:8080/api/message/102 - GET
//http://localhost:8080/api/message - POST 

@RestController
@RequestMapping("/api")
public class Controller {

	private IUserDAO dao = new UserDAO(); 
	
	@GetMapping("/health")
	public String health() {
		return "Chat Service is UP... "; 
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return dao.getAllUsers(); 
	}
	
	@GetMapping("/users/{userId}")
	public UserProfile getUserById(@PathVariable String userId) {
		return dao.getUser(userId); 
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody Loginparams loginparams ) {
		return dao.loginUser(loginparams.getEmail(), loginparams.getPassword()); 
	}
	
	@PostMapping("/register")
	public boolean register(@RequestBody User user ) {
		return dao.registerUser(user); 
	}
	
	@PostMapping("/changepassword")
	public boolean changePassword(@RequestBody ChangePasswordParams params ) {
		return dao.changePassword(params.getEmail(),params.getPassword()); 
	}
	
	@DeleteMapping("/users")
	public boolean deleteUser(@RequestBody  DeleteUserParams params) {
		return dao.deleteUser(params.getEmail(),params.getPassword()); 
	}
	
	
	
}

