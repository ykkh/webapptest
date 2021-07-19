package com.proquest.interview.phonebook.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.proquest.interview.phonebook.model.Person;
import com.proquest.interview.util.DatabaseUtil;

public class PhoneBookDaoTest {
	
	private  static PhoneBookDao phoneBookDao;

	@BeforeClass
	public static void init() {
		DatabaseUtil.initDB();
		phoneBookDao = new PhoneBookDaoImpl();
	}
	
	
	@Test
	public void testInsert() {
		Person newPerson = new Person("John Smith", "(248) 123-4567", "1234 Sand Hill Dr, Royal Oak, MI");
		Person newPerson2 = new Person("Cynthia Smith", " (824) 128-8758", "875 Main St, Ann Arbor, MI");
		int resultOne = phoneBookDao.add(newPerson); 
		int resultTwo = phoneBookDao.add(newPerson2); 
		
		
		assertEquals(1, resultOne);
		assertEquals(1, resultTwo);
	}
	
	@Test
	public void testNoResults() {
		assertNull(phoneBookDao.find("Ethan Jade")) ;
	}
	
	@Test
	public void testFind() {
		testInsert(); // wouldn't need to call it if it's not in-mem db
		Person expected = new Person("John Smith", "(248) 123-4567", "1234 Sand Hill Dr, Royal Oak, MI");
		Person acutalResult = phoneBookDao.find("John Smith");
		assertEquals(expected, acutalResult);
		
	}
	
	@Test
	public void testFindAll() {
		testInsert();
		assertEquals(4, phoneBookDao.findAll().size()); // pre-inserted 2 records from initDB
	}
	
	
	
}
