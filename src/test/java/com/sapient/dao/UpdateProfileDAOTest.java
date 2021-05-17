package com.sapient.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sapient.dao.UpdateProfileDAO;
import com.sapient.exceptions.EmailNotValidException;
import com.sapient.exceptions.NameTooSmallException;
import com.sapient.interfaces.IUpdateProfileDAO;

class UpdateProfileDAOTest {

	private IUpdateProfileDAO updateProfileDao = null;

	@BeforeEach
	public void setUpProfileDao() {
		updateProfileDao = new UpdateProfileDAO();
	}
	
	@Test
	@DisplayName("Should Return False When Name Not Updated!")
	void should_ReturnFalse_When_NameNotUpdated() throws NameTooSmallException {
		boolean expected = false;
		boolean actual = updateProfileDao.updateName(124, "ABC");
		
		assertEquals(expected , actual);
	}

	@Test
	@DisplayName("Should Return False When Email Not Updated!")
	void should_ReturnFalse_When_EmailNotUpdated() throws EmailNotValidException {
		boolean expected = false;
		boolean actual = updateProfileDao.updateEmail(124, "test@testing.com");
		
		assertEquals(expected , actual);
	}

}
