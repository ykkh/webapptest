package com.proquest.interview.phonebook.service;

import java.util.List;

import com.proquest.interview.phonebook.model.Person;

public interface PhoneBook {
	public Person findPerson(String firstName, String lastName);
	public void addPerson(Person newPerson);
	List<Person> getAllPhoneBook();
}
