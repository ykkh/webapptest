package com.proquest.interview.phonebook.service;

import java.util.List;

import com.proquest.interview.phonebook.dao.PhoneBookDao;
import com.proquest.interview.phonebook.dao.PhoneBookDaoImpl;
import com.proquest.interview.phonebook.model.Person;

public class PhoneBookImpl implements PhoneBook {

	private  PhoneBookDao phoneBookDao;
	
	public PhoneBookImpl() {
		phoneBookDao = new PhoneBookDaoImpl();
	}

	@Override
	public void addPerson(Person newPerson) {
		//business logic might happen here
		
		if(newPerson == null) {
			throw new IllegalArgumentException();
		}
		
		phoneBookDao.add(newPerson);
	}
	
	@Override
	public List<Person> getAllPhoneBook() {
		//business logic might happen here
		return phoneBookDao.findAll();
	}


	@Override
	public Person findPerson(String firstName, String lastName) {
		
		if(firstName == null || lastName == null) {
			throw new IllegalArgumentException();
		}
		
		String name = firstName.trim() + " " + lastName.trim(); // assume it as business logic

		Person p = phoneBookDao.find(name);

		return p;
	}
	
	

}
