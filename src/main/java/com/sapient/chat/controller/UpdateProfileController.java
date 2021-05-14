package com.sapient.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.chat.dao.UpdateProfileDAO;
import com.sapient.chat.entity.UpdateProfile;
import com.sapient.chat.exceptions.AgeLessThan18Exception;
import com.sapient.chat.exceptions.EmailNotValidException;
import com.sapient.chat.exceptions.NameTooSmallException;
import com.sapient.chat.exceptions.PasswordNotStrongException;
import com.sapient.chat.interfaces.IUpdateProfileDAO;

@RestController
@RequestMapping("/api")
public class UpdateProfileController {

	private IUpdateProfileDAO dao = new UpdateProfileDAO();

	@GetMapping("/healthy")
	public String health() {
		return "Update Profile Controller";
	}

	@PutMapping("/changeEmail/{userId}")
	public String changeEmail(@PathVariable int userId, @RequestBody String email) {
		try {
			if(dao.updateEmail(userId, email))
				return "Email updated";
		} catch (EmailNotValidException e) {
			return e.getMessage();
		}
		return "Unknown Error";
	}

	@PutMapping("changeName/{userId}")
	public String changeName(@PathVariable int userId, @RequestBody UpdateProfile updateProfile) {
		try {

			if(dao.updateName(userId, updateProfile.getName()))
				return "Name updated";
		} catch (NameTooSmallException e) {
			return e.getMessage();
		}
		return "Unknown Error";
	}

	@PutMapping("changePassword/{userId}")
	public String changePassword(@PathVariable int userId, @RequestBody UpdateProfile updateProfile) {
		try {
			if(dao.updatePassword(userId, updateProfile.getPassword()))
				return "Password updated";
		} catch (PasswordNotStrongException e) {
			return e.getMessage();
		}
		return "Unknown Error";
	}

	@PutMapping("changeDOB/{userId}")
	public String changeDOB(@PathVariable int userId, @RequestBody UpdateProfile updateProfile) {
		try {
			if(dao.updateDOB(userId, updateProfile.getDob()))
				return "Date of birth updated";
		} catch (AgeLessThan18Exception e) {
			return e.getMessage();
		}
		return "Unknown Error";
	}
}
