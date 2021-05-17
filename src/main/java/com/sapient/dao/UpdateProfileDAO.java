package com.sapient.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;

import com.sapient.exceptions.AgeLessThan18Exception;
import com.sapient.exceptions.EmailNotValidException;
import com.sapient.exceptions.NameTooSmallException;
import com.sapient.exceptions.PasswordNotStrongException;
import com.sapient.interfaces.IUpdateProfileDAO;
import com.sapient.utils.GetConnection;

public class UpdateProfileDAO implements IUpdateProfileDAO{

	public boolean updateEmail(int userId, String email) throws EmailNotValidException{
		
		boolean isEmail = false;
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		isEmail = pat.matcher(email).matches();
		
		if(!isEmail)
			throw new EmailNotValidException();
		
		String sql = "update users set email = ? where user_id = ?";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, email);
			ps.setInt(2, userId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean updateName(int userId, String name) throws NameTooSmallException{
		if(name.length() < 1)
			throw new NameTooSmallException();
		
		String sql = "update users set name = ? where user_id = ?";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, userId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatePassword(int userId, String password) throws PasswordNotStrongException{

		//Checking password strength
		String strength;
		int n = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecialChar = false;
        Set<Character> set = new HashSet<Character>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));
        
        for (char i : password.toCharArray()) {
            if (Character.isLowerCase(i)) hasLower = true;
            if (Character.isUpperCase(i)) hasUpper = true;
            if (Character.isDigit(i)) hasDigit = true;
            if (set.contains(i)) hasSpecialChar = true;
        }
        
        if (hasDigit && hasLower && hasUpper && hasSpecialChar && (n >= 8)) strength = "Strong";
        else if ((hasLower || hasUpper || hasSpecialChar) && (n >= 6)) strength = "Moderate";
        else strength = "Weak";
        
        if(strength == "Weak")
        	throw new PasswordNotStrongException();
        
        //Updating password in mysql
		String sql = "update users set password = ? where user_id = ?";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, userId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateDOB(int userId, LocalDate dob) throws AgeLessThan18Exception{
		LocalDate start = LocalDate.from((TemporalAccessor) dob);
		LocalDate end = LocalDate.now();
		int age = (int)ChronoUnit.YEARS.between(start, (Temporal) end);
		
		Date date = Date.valueOf(dob);
		
		if(age < 18)
			throw new AgeLessThan18Exception();
		
		try {
			String sql = "update users set dob = ? where user_id = ?";
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setDate(1, date);
			ps.setInt(2, userId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
}
