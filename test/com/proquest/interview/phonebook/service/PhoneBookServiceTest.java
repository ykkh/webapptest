package com.proquest.interview.phonebook.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.proquest.interview.phonebook.dao.PhoneBookDao;
import com.proquest.interview.phonebook.dao.PhoneBookDaoImpl;
import com.proquest.interview.phonebook.model.Person;

@RunWith(MockitoJUnitRunner.class)
public class PhoneBookServiceTest {
	
	@InjectMocks
	PhoneBook phoneBook = new PhoneBookImpl();
	
	@Mock
	PhoneBookDao phoneDao = new PhoneBookDaoImpl();
	
	@Test
	public void testFind() {
		Person expectedResult = new Person("John Smith", "(248) 123-4567", "1234 Sand Hill Dr, Royal Oak, MI");
		when(phoneDao.find("John Smith")).thenReturn(expectedResult);
		Person actualResult = phoneBook.findPerson("John", "Smith");
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNoOne() {
		phoneBook.addPerson(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullFirstName() {
		phoneBook.findPerson(null, "Ruby");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullLastName() {
		phoneBook.findPerson("Diamon", null);
	}
	
}
