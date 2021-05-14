package com.sapient.chat.interfaces;

import java.time.LocalDate;

import com.sapient.chat.exceptions.AgeLessThan18Exception;
import com.sapient.chat.exceptions.EmailNotValidException;
import com.sapient.chat.exceptions.NameTooSmallException;
import com.sapient.chat.exceptions.PasswordNotStrongException;

public interface IUpdateProfileDAO {
	//Update email
	public boolean updateEmail(int userId, String email) throws EmailNotValidException;
	
	//Update Name
	public boolean updateName(int userId, String name) throws NameTooSmallException;
	
	//Update password
	public boolean updatePassword(int userId, String password) throws PasswordNotStrongException;
	
	//Update d.o.b.
	public boolean updateDOB(int userId, LocalDate dob) throws AgeLessThan18Exception;
}
